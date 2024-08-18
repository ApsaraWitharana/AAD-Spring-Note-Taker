package lk.ijse.gdse68.notetraker.bo;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;
import lk.ijse.gdse68.notetraker.util.ApiUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // service class ek manage krnw // spring wisin component annotation ek meta annotate krl tiyenne
public final class NoteBOImpl implements NoteBO {


    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(ApiUtil.createNoteId());
        System.out.println(noteDTO);
        return "Note saved successfully with ID: " + noteDTO.getNoteId();
    }

    @Override
    public boolean updateNote(NoteDTO noteDTO) {
        return false;
    }

    @Override
    public boolean deleteNote(NoteDTO noteDTO) {
        return false;
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return null;
    }
}
