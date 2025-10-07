package com.lorezosproject.noteapp.dao;

import java.util.List;

import com.lorezosproject.noteapp.entity.NoteDetailEntity;
import com.lorezosproject.noteapp.entity.UserEntity;

//data transfer objcet interface to standardize classes
public interface NoteDao {

    void saveRegister(UserEntity userEntity);

    NoteDetailEntity saveNote(NoteDetailEntity noteDetailEntity);

    List<NoteDetailEntity> retrieveNotes(String username);

    void deleteNote(int theId);
}
