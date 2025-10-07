package com.lorezosproject.noteapp.dto;

public class GetNoteDTO {

    //fields
    private int id;

    private String username;
    
    private String severity;

    private String date;

    private String body;


    //contructors
    public GetNoteDTO(){

    }

    public GetNoteDTO(int id, String username, String severity, String date, String body) {
        this.id = id;
        this.username = username;
        this.severity = severity;
        this.date = date;
        this.body = body;
    }


    //getters / setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    
}
