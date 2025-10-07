package com.lorezosproject.noteapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PostNoteDTO {

    //fields
    @NotNull
    private String username;

    @Pattern(regexp = "^(High|Medium|Low)$")
    @NotNull
    private String severity;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[01])/\\d{4}$", message = "The date is not in a valid format")
    @NotNull
    private String date;

    @NotNull
    private String body;
    
    
    //getter/setter
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
