package lk.ijse.gdse68.notetraker.controller;

import lk.ijse.gdse68.notetraker.customObj.NoteResponse;
import lk.ijse.gdse68.notetraker.exception.DataPersistFailedException;
import lk.ijse.gdse68.notetraker.exception.NoteNoteFound;
import lk.ijse.gdse68.notetraker.service.NoteService;
import lk.ijse.gdse68.notetraker.dto.iml.NoteDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")//component annotation  ek meta annotate wel tiyenne
@RequiredArgsConstructor
public class NoteController {

    @Autowired //Automatically injects dependencies--externally inject krn ek dependency//
    //why useing bean annotation - Explicitly defines beans and their lifecycle methods
    // interface true ek looscuple wenwa -change krnwanm okkom change krnn on hinda mek krnne interface true -interface ekk agreement why-sevice ek impl krnne interface eken ne ehinda tnyi ek wenne

    private final NoteService noteService;

    //TODO: helth check
//    @GetMapping("health")
//    public String healthCheck(){
//        return "Note traker is running";
//
//
//    }
   //TODO: CRUD
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNote(@RequestBody NoteDTO note){
        //if-el ekk - if else godak use krnw
        if (note == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                noteService.saveNote(note);
                return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
            }catch (DataPersistFailedException e){
                return new  ResponseEntity<>(HttpStatus.NOT_FOUND);

            }catch (Exception e){
                return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }




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
       return noteService.getAllNotes();
    }

    //get
    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse getNote(@PathVariable ("noteId") String noteId){
        System.out.println(noteId);
        return noteService.getSelectedNote(noteId);

    }


    //update
//    @ResponseStatus(HttpStatus.NO_CONTENT)//204 n update,delete wenn status ekk
    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDTO note) {

        try {
            if (note == null && (noteId == null || noteId.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            try {
                noteService.updateNote(noteId, note);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (NoteNoteFound e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //delete
//    @ResponseStatus(HttpStatus.NO_CONTENT)

    @DeleteMapping(value ="/{noteId}" )
  //  ResponseEntity<String> - is object - using send client to resp -msg and status code  in details dewal ywnn use krnne jenaric ekk apit ona data type dgnn
    public ResponseEntity<Void> deleteNote(@PathVariable("noteId") String noteId ){
       // noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.BAD_REQUEST) // boolean ekk kin check krn hind mem dnne //no content 204-http
        try {
            noteService.deleteNote(noteId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoteNoteFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //this is stander for res full!! - Advantage to res full -

        //req-http://localhost:8080/note/api/v1/notes/NODE: c785fc62-8b06-4cdf-9f31-1226f1e98be6


    }

//post patch body tiyenwa.//delete get body ne
}
