package lk.ijse.gdse68.notetraker.controller;

import lk.ijse.gdse68.notetraker.bo.NoteBO;
import lk.ijse.gdse68.notetraker.dto.NoteDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")//component annotation  ek meta annotate wel tiyenne
@RequiredArgsConstructor
public class NoteController {
    @Autowired
    private  final NoteBO noteBO;
   //TODO: CRUD
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){

        var saveData = noteBO.saveNote(note);
        return ResponseEntity.ok(saveData);

        //TODO: Handle with BO
//        note.setNoteId(ApiUtil.createNoteId());
//        System.out.println(note);
      //  return ResponseEntity.ok("Note created successfully");

        //req== http://localhost:8080/note/api/v1/notes
        //resp-Note created successfully
        //NoteDTO(noteId=NODE: 1aab0adb-89d2-4534-88de-c922cc8ba730, noteTitle=Rest sevices, noteDesc=Explaing the rest, priorityLevel=P1, createDate=20240818)
        //resp -Note saved successfully with ID: NODE: eaaef5c2-8fd3-4713-a276-248f51508929 set this resp to BO  layer
    }
    @GetMapping(value = "allnotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNote(){
       return noteBO.getAllNotes();
    }

    //get
    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable ("noteId") String noteId){
        System.out.println(noteId);
        return noteBO.getSelectedNote(noteId);

    }

    //update
    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDTO note) {
        System.out.println(noteId);
        System.out.println(note+ " Updated");
        boolean isUpdated = noteBO.updateNote(noteId,note);

    }

    //delete
    @DeleteMapping(value ="/{noteId}" )
    public void deleteNote(@PathVariable("noteId") String noteId ){
        System.out.println(noteId + "Delete");
        boolean isDeleted = noteBO.deleteNote(noteId);


    }

//post patch body tiyenwa.//delete get body ne
}
