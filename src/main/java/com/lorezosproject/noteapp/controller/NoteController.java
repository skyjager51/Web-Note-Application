package com.lorezosproject.noteapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lorezosproject.noteapp.dto.GetNoteDTO;
import com.lorezosproject.noteapp.dto.PostNoteDTO;
import com.lorezosproject.noteapp.entity.UserEntity;
import com.lorezosproject.noteapp.service.NoteService;
import com.lorezosproject.noteapp.utilities.GenerateDTOList;
import com.lorezosproject.noteapp.utilities.RetrieveUsername;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class NoteController {

    //inject the Services
    private NoteService noteService;
    private GenerateDTOList generateDTOList;
    private RetrieveUsername retrieveUsername;

    //construct the class with the injected serivices
    public NoteController(NoteService noteService, GenerateDTOList generateDTOList, RetrieveUsername retrieveUsername){
        this.noteService = noteService;
        this.generateDTOList = generateDTOList;
        this.retrieveUsername = retrieveUsername;
    }

    //endpoint to save new notes
    @PostMapping("/save")
    public ResponseEntity<?> saceNewNote(@RequestBody PostNoteDTO noteDTO) {
        
        
        try{
            //set the username based on the current session
            noteDTO.setUsername(retrieveUsername.retrieveUsernameFromSecurity());

            //return an http response based on the success/fail of the operation
            noteService.saveNote(noteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "note created"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "note not created"));
        }
        
    }

    //endpoint to save new users
    @PostMapping("/register")
    public ResponseEntity<?> saveNewUser(@RequestBody UserEntity userEntity){

        try{
            //save the new user
            noteService.saveRegister(userEntity);

            //return an http response based on the success/fail of the operation
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "user created"));
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "user not created"));
        }
    }
    
    //endpoint to retrieve the notes
    public List<GetNoteDTO> getNotesSortedByDate(){

        //retrieving the username
        String username = retrieveUsername.retrieveUsernameFromSecurity();

        //retrieving the list of notes
        List<GetNoteDTO> tempGetNoteDTOs;
        try{
            tempGetNoteDTOs = generateDTOList.returnNotesSorted(username, 0);
        }
        catch (Exception e){
            tempGetNoteDTOs = null;
        }

        return tempGetNoteDTOs;
    }

    //endpoint to retrieve the notes
    @GetMapping("/get-sorted-note/{sort}")
    public List<GetNoteDTO> getNotesSortedBySeverity(@PathVariable int sort){

        //retrieving the username
        String username = retrieveUsername.retrieveUsernameFromSecurity();

        //retrieving the list of notes
        List<GetNoteDTO> tempGetNoteDTOs;
        try{
            tempGetNoteDTOs = generateDTOList.returnNotesSorted(username, sort);
        }
        catch (Exception e){
            tempGetNoteDTOs = null;
        }

        return tempGetNoteDTOs;
    }

    //endpoint to delete a note 
    @DeleteMapping("/delete/{theId}")
    public void deleteNote(@PathVariable int theId){

        //after retrieving the id, delete the related notes
        noteService.deleteNote(theId);
    }

}
