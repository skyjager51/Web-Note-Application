package com.lorezosproject.noteapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "note")
public class NoteBodyEntity {

    //fields 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "note_body")
    private String body;

    //create the relation with the note detail entity, this is the owning side of the relation 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_detail_id")
    private NoteDetailEntity noteDetailEntity;

    //constructor
    public NoteBodyEntity(){

    }

    public NoteBodyEntity(String body, NoteDetailEntity noteDetailEntity) {
        this.body = body;
        this.noteDetailEntity = noteDetailEntity;
    }

    //setter/getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public NoteDetailEntity getNoteDetailEntity() {
        return noteDetailEntity;
    }

    public void setNoteDetailEntity(NoteDetailEntity noteDetailEntity) {
        this.noteDetailEntity = noteDetailEntity;
    }

    
}
