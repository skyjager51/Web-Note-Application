package com.lorezosproject.noteapp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.lorezosproject.noteapp.dao.NoteDao;
import com.lorezosproject.noteapp.dto.PostNoteDTO;
import com.lorezosproject.noteapp.entity.AuthoritiesEntity;
import com.lorezosproject.noteapp.entity.AuthoritiesId;
import com.lorezosproject.noteapp.entity.NoteBodyEntity;
import com.lorezosproject.noteapp.entity.NoteDetailEntity;
import com.lorezosproject.noteapp.entity.UserEntity;

@Component
public class NoteServiceImpl implements NoteService{

    //inject the dao interface
    private NoteDao noteDao;

    private PasswordEncoder passwordEncoder;

    public NoteServiceImpl(NoteDao noteDao, PasswordEncoder passwordEncoder){
        this.noteDao = noteDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveRegister(UserEntity userEntity) {
        String password = userEntity.getPassword();
        AuthoritiesEntity tempAuthority = new AuthoritiesEntity();

        //set the value
        tempAuthority.setId(new AuthoritiesId(userEntity.getUsername(), "ROLE_USER"));

        //set the bi-diretcional relation
        userEntity.addAuthority(tempAuthority);

        //create the bycript password
        String encodedPassword = passwordEncoder.encode(password);
        userEntity.setPassword(encodedPassword);

        //set enabled
        userEntity.setEnabled(1);

        noteDao.saveRegister(userEntity);
    }

    @Override
    public NoteDetailEntity saveNote(PostNoteDTO noteDTO) {
        
        //creating class object to assign them the relatice values
        NoteDetailEntity noteDetailEntity = new NoteDetailEntity();
        NoteBodyEntity noteBodyEntity = new NoteBodyEntity();

        //assigning te values to the classes
        noteDetailEntity.setUsername(noteDTO.getUsername());
        noteDetailEntity.setSeverity(noteDTO.getSeverity());
        noteDetailEntity.setDate(noteDTO.getDate());

        noteBodyEntity.setBody(noteDTO.getBody());

        //creating the relation between the tables
        noteDetailEntity.setNoteBodyEntity(noteBodyEntity);
        noteBodyEntity.setNoteDetailEntity(noteDetailEntity);

        return noteDao.saveNote(noteDetailEntity);
    }

    @Override
    public List<NoteDetailEntity> retrieveNotesSeveritySorted(String username) {
        
        //retrieve the notes
        List<NoteDetailEntity> noteList = noteDao.retrieveNotes(username);

        //sort the notes based on the input 
        noteList.sort(Comparator.comparing(element -> element.getNumericValueForSeverity()));

        return noteList;
    }

    @Override
    public List<NoteDetailEntity> retrieveNotesDateSorted(String username) {
        
        //retrieve the notes
        List<NoteDetailEntity> noteList = noteDao.retrieveNotes(username);

        //sort the notes based on the input
        noteList.sort(Comparator.comparing(element -> element.getDateValueForDate()));

        return noteList;
    }

    @Override
    public void deleteNote(int theId) {
        //delete the specified note
        noteDao.deleteNote(theId);
    }

}
