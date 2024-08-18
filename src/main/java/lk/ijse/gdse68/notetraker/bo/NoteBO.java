package lk.ijse.gdse68.notetraker.bo;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;

import java.util.List;

public sealed interface NoteBO permits NoteBOImpl {
    String saveNote(NoteDTO noteDTO);
    boolean updateNote(NoteDTO noteDTO);
    boolean deleteNote(NoteDTO noteDTO);
    NoteDTO getSelectedNote(String noteId);

    List<NoteDTO> getAllNotes();

    //sealed -inherit ek controller krnwa permit class ekt witharyi inherit krnn puluwan

}
