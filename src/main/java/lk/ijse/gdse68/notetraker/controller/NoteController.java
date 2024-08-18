package lk.ijse.gdse68.notetraker.controller;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;
import lk.ijse.gdse68.notetraker.util.ApiUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")//component annotation  ek meta annotate wel tiyenne
public class NoteController {
   //TODO: CRUD
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){


        //TODO: Handle with BO
        note.setNoteId(ApiUtil.createNoteId());
        System.out.println(note);
        return ResponseEntity.ok("Note created successfully");

        //req== http://localhost:8080/note/api/v1/notes
        //resp-Note created successfully
        //NoteDTO(noteId=NODE: 1aab0adb-89d2-4534-88de-c922cc8ba730, noteTitle=Rest sevices, noteDesc=Explaing the rest, priorityLevel=P1, createDate=20240818)
    }
    @GetMapping(value = "allnotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNote(){
        return null;
    }

    //get
    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable ("noteId") String noteId){
        System.out.println(noteId);
        return null;
    }

    //update
    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable("noteId") String noteId,@RequestBody NoteDTO note ){
        System.out.println(noteId);
        System.out.println(note + "Update");

    }

    //delete
    @DeleteMapping(value = "/{noteId}")
    public void deleteNote(@PathVariable("noteId") String noteId ){
        System.out.println(noteId + "Delete");


    }

//post patch body tiyenwa.//delete get body ne
}
