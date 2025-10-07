package com.lorezosproject.noteapp.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

//creating the join column id for the authorities entity 

@Embeddable
public class AuthoritiesId implements Serializable{

    private String username;
    private String authority;

    public AuthoritiesId(){

    }

    public AuthoritiesId(String username, String authority) {
        this.username = username;
        this.authority = "ROLE_USER";
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthoritiesId that = (AuthoritiesId) o;
        return Objects.equals(username, that.username) &&
               Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authority);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    
}
