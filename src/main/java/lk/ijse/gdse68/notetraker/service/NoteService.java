package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.customObj.NoteResponse;
import lk.ijse.gdse68.notetraker.dto.iml.NoteDTO;

import java.util.List;

public  interface NoteService {
    void saveNote(NoteDTO noteDTO);
    void updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote(String noteId);
    NoteResponse getSelectedNote(String noteId);

    List<NoteDTO> getAllNotes();

    //sealed -inherit ek controller krnwa permit class ekt witharyi inherit krnn puluwan

}
