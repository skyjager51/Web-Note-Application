package com.lorezosproject.noteapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthoritiesEntity {

    @EmbeddedId
    private AuthoritiesId id = new AuthoritiesId();

    //create the relation with the user entity, this is the owning side with the foreign key 
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("username")
    @JoinColumn(name = "username")
    private UserEntity userEntity;

    //constructors
    public AuthoritiesEntity(){

    }

    public AuthoritiesEntity(String auth) {
        this.id.setAuthority(auth);
    }


    public UserEntity getUserEntity() {
        return userEntity;
    }

    public AuthoritiesId getId() {
        return id;
    }

    public void setId(AuthoritiesId id) {
        this.id = id;
    }

    //set the relation with the User Entity
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        if (this.id == null) {
            this.id = new AuthoritiesId();
        }
        this.id.setUsername(userEntity.getUsername());
    }

 
}
