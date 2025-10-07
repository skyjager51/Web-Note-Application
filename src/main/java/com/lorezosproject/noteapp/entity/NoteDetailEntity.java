package com.lorezosproject.noteapp.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "note_details")
public class NoteDetailEntity {

    //fields 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ids")
    private int id;

    @Column(name = "username_reference")
    private String username;

    @Column(name = "note_importnace")
    private String severity;

    @Column(name = "note_date")
    private String date;

    //setting up the relation, this is the owned side
    @OneToOne(mappedBy = "noteDetailEntity", cascade = CascadeType.ALL)
    private NoteBodyEntity noteBodyEntity;

    //constructors
    public NoteDetailEntity(){

    }

    public NoteDetailEntity(String username, String severity, String date) {
        this.username = username;
        this.severity = severity;
        this.date = date;
    }

    //getter / setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NoteBodyEntity getNoteBodyEntity() {
        return noteBodyEntity;
    }

    public void setNoteBodyEntity(NoteBodyEntity noteBodyEntity) {
        this.noteBodyEntity = noteBodyEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //metohds to facilitate sorting 
    public LocalDate getDateValueForDate(){
        String tempString = date;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate sortDate = LocalDate.parse(tempString, formatter);

        return sortDate;  
    }

    public int getNumericValueForSeverity(){
        Map<String, Integer> translateMap = Map.of("High", 1, "Medium", 2, "Low" , 3);

        return translateMap.get(severity);
    }

    
}
