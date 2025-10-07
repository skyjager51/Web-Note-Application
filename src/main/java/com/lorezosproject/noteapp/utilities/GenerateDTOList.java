package com.lorezosproject.noteapp.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lorezosproject.noteapp.dto.GetNoteDTO;
import com.lorezosproject.noteapp.entity.NoteDetailEntity;
import com.lorezosproject.noteapp.service.NoteService;

@Component
public class GenerateDTOList {

    //injecting the service
    private NoteService noteService;

    public GenerateDTOList(NoteService noteService){
        this.noteService = noteService;
    }

    //method to return the note ordered by the input value
    public List<GetNoteDTO> returnNotesSorted(String username, int sorted){

        //of sorted = 0 sort by date, if anything else sort by severity
        List<NoteDetailEntity> tempNoteDetailEntities;
        if(sorted == 0){
            tempNoteDetailEntities = noteService.retrieveNotesDateSorted(username);
        }
        else{
            tempNoteDetailEntities = noteService.retrieveNotesSeveritySorted(username);
        }
        
        List<GetNoteDTO> tempGetNoteDTOs = new ArrayList<>();

        //map each note to a getnotdto to pass it to the rest api
        for(NoteDetailEntity note : tempNoteDetailEntities){
            GetNoteDTO tempNote = new GetNoteDTO(note.getId(), note.getUsername(),
                note.getSeverity(), note.getDate(), note.getNoteBodyEntity().getBody());

            tempGetNoteDTOs.add(tempNote);
        }

        return tempGetNoteDTOs;
    }
}
