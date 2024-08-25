package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;

import lk.ijse.gdse68.notetraker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // service class ek manage krnw // spring wisin component annotation ek meta annotate krl tiyenne
public final class NoteServiceImpl implements NoteService {

    List<NoteDTO> saveNoteTmp = new ArrayList<>();
    public NoteServiceImpl(){
        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a67-2ebc-41b2-1de6-4e9bcdba65bb","Principles of SE","SE desc","P1","23456"));
        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a68-3ebc-41b2-2de6-4e9bcdba65bb","Principles of SE","SE desc","P2","23451"));
        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a69-4ebc-41b2-3de6-4e9bcdba65bb","Principles of SE","SE desc","P3","12345"));
        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a60-5ebc-41b2-4de6-4e9bcdba65bb","Principles of SE","SE desc","P4","56789"));
        System.out.println(saveNoteTmp); //save temp list-note dto type
    }

    @Override
    public String saveNote(NoteDTO noteDTO) {
       noteDTO.setNoteId(AppUtil.createNoteId());
//        System.out.println(noteDTO);
        saveNoteTmp.add(noteDTO);
        return "Note saved successfully with ID: " + noteDTO.getNoteId();

    }

    @Override
    public void updateNote(String noteId,NoteDTO incomeNoteDTO) {
        for (NoteDTO updateNote :saveNoteTmp){
            if (updateNote.getNoteId().equals(noteId)){
                updateNote.setNoteDesc(incomeNoteDTO.getNoteDesc());
                updateNote.setNoteTitle(incomeNoteDTO.getNoteTitle());
                updateNote.setPriorityLevel(incomeNoteDTO.getPriorityLevel());
                updateNote.setCreateDate(incomeNoteDTO.getCreateDate());


            }
        }

    }

    @Override
    public boolean deleteNote(String noteId) {
        System.out.println(noteId+"Deleted");
        return true;
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        System.out.println(noteId);
        for (NoteDTO noteDTO:saveNoteTmp){
            if (noteDTO.getNoteId().equals(noteId)){
                return noteDTO;
            }
        }
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return saveNoteTmp;
    }
}
