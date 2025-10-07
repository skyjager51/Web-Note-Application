package com.lorezosproject.noteapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lorezosproject.noteapp.dto.PostNoteDTO;
import com.lorezosproject.noteapp.entity.NoteDetailEntity;
import com.lorezosproject.noteapp.entity.UserEntity;

//interface for the service layer
@Service
public interface NoteService {

    void saveRegister(UserEntity userEntity);

    NoteDetailEntity saveNote(PostNoteDTO noteDTO);

    List<NoteDetailEntity> retrieveNotesSeveritySorted(String username);

    List<NoteDetailEntity> retrieveNotesDateSorted(String username);

    void deleteNote(int theId);
}
