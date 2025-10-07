package com.lorezosproject.noteapp.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    //fileds 
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")     
    private String password;

    @Column(name = "enabled")
    private int enabled;

    //setting up the relation, this is the owned side
    @OneToMany(mappedBy = "userEntity", cascade = {CascadeType.ALL})
    private List<AuthoritiesEntity> authorities;

    //contructors
    public UserEntity(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public UserEntity(){

    }

    //getter/setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<AuthoritiesEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthoritiesEntity> authorities) {
        this.authorities = authorities;
    }

    //function for adding an authority ad setting up the bidirectional connection 
    public void addAuthority(AuthoritiesEntity authoritiesEntity){
        if (authorities == null){
            authorities = new ArrayList<>();
        }

        authorities.add(authoritiesEntity);

        authoritiesEntity.setUserEntity(this);
    }
}
