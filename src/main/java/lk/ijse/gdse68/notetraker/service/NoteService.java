package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;

import java.util.List;

public sealed interface NoteService permits NoteServiceImpl {
    String saveNote(NoteDTO noteDTO);
    void updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote(String noteId);
    NoteDTO getSelectedNote(String noteId);

    List<NoteDTO> getAllNotes();

    //sealed -inherit ek controller krnwa permit class ekt witharyi inherit krnn puluwan

}
