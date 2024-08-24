package lk.ijse.gdse68.notetraker.bo;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;

import lk.ijse.gdse68.notetraker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // service class ek manage krnw // spring wisin component annotation ek meta annotate krl tiyenne
public final class NoteBOImpl implements NoteBO {


    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteId());
        System.out.println(noteDTO);
        return "Note saved successfully with ID: " + noteDTO.getNoteId();
    }

    @Override
    public boolean updateNote(String noteId,NoteDTO noteDTO) {
        System.out.println(noteId);
        System.out.println(noteDTO);
        return true;
    }

    @Override
    public boolean deleteNote(String noteId) {
        System.out.println(noteId+"Deleted");
        return true;
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        System.out.println(noteId);

        return new NoteDTO(
                "NOTE 4f8a0a67-2ebc-41b2-9de6-4e9bcdba65bb",
                "REST services",
                "Explain the REST",
                "P1",
                "20240818"
        );
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return null;
    }
}
