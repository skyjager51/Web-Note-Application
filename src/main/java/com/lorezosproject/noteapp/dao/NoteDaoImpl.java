package com.lorezosproject.noteapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lorezosproject.noteapp.entity.NoteDetailEntity;
import com.lorezosproject.noteapp.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class NoteDaoImpl implements NoteDao{

    //injecting the entitymanager
    private EntityManager entityManager;

    public NoteDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //save the username and password in the db
    @Override
    @Transactional
    public void saveRegister(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    //save the note detail and the note body
    @Override
    @Transactional
    public NoteDetailEntity saveNote(NoteDetailEntity noteDetailEntity) {
        return entityManager.merge(noteDetailEntity);
    }

    //retrieve the note detail and the note body
    @Override
    public List<NoteDetailEntity> retrieveNotes(String username) {
        TypedQuery<NoteDetailEntity> query = entityManager.createQuery("SELECT n FROM NoteDetailEntity n WHERE n.username = :data",
             NoteDetailEntity.class);

        query.setParameter("data", username);

        List<NoteDetailEntity> tempNoteDetailEntities = query.getResultList();

        return tempNoteDetailEntities;
    }

    //delete the specified note
    @Override
    @Transactional
    public void deleteNote(int theId) {
        NoteDetailEntity noteDetailEntity = entityManager.find(NoteDetailEntity.class, theId);

        entityManager.remove(noteDetailEntity);
    }


}
