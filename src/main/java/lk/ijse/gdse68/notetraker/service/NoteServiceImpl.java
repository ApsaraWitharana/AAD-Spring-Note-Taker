package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.customObj.NoteErrorResponse;
import lk.ijse.gdse68.notetraker.customObj.NoteResponse;
import lk.ijse.gdse68.notetraker.dao.NoteDAO;
import lk.ijse.gdse68.notetraker.dto.iml.NoteDTO;

import lk.ijse.gdse68.notetraker.entity.NoteEntity;
import lk.ijse.gdse68.notetraker.exception.DataPersistFailedException;
import lk.ijse.gdse68.notetraker.exception.NoteNoteFound;
import lk.ijse.gdse68.notetraker.util.AppUtil;
import lk.ijse.gdse68.notetraker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service // service class ek manage krnw // spring wisin component annotation ek meta annotate krl tiyenne
public  class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO noteDAO;
    @Autowired
    private Mapping mapping;

//    List<NoteDTO> saveNoteTmp = new ArrayList<>();
//    public NoteServiceImpl(){
//        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a67-2ebc-41b2-1de6-4e9bcdba65bb","Principles of SE","SE desc","P1","23456"));
//        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a68-3ebc-41b2-2de6-4e9bcdba65bb","Principles of SE","SE desc","P2","23451"));
//        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a69-4ebc-41b2-3de6-4e9bcdba65bb","Principles of SE","SE desc","P3","12345"));
//        saveNoteTmp.add(new NoteDTO("NOTE 4f8a0a60-5ebc-41b2-4de6-4e9bcdba65bb","Principles of SE","SE desc","P4","56789"));
//        System.out.println(saveNoteTmp); //save temp list-note dto type
//    }

    @Override
    public void saveNote(NoteDTO noteDTO) {
     //  noteDTO.setNoteId(AppUtil.createNoteId());
//        System.out.println(noteDTO);
    //    saveNoteTmp.add(noteDTO);
        //TODO:SET DAO
        noteDTO.setNoteId(AppUtil.createNoteId());
        var NoteEntity = mapping.convertToEntity(noteDTO);
        var saveNote =   noteDAO.save(NoteEntity);
        System.out.println(noteDTO);

        if (saveNote == null){
            throw new DataPersistFailedException("cannot save note");
        }
//       return "Note saved successfully with ID: " + noteDTO.getNoteId();

        //req-http://localhost:8080/note/api/v1/notes


    }

    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDto) {
//handling null point exception to using -  Optional key word use
         Optional<NoteEntity> tmpNoteEntity = noteDAO.findById(noteId);
         if (!tmpNoteEntity.isPresent()){
             //nathinam

             throw new NoteNoteFound("Note note Found");

         }else {
             //option type ek ob ek return krl ek set krgnnwa dto ekt
             //thiyenm -incomeNoteDto ek return wenwa
             //jpa wl update na ek krnne mem // nattm custom method ekk ghnn one
             tmpNoteEntity.get().setNoteDesc(incomeNoteDto.getNoteDesc()); // value ek eliyt arn eket sete kranawa new value ek set krnwa
             tmpNoteEntity.get().setNoteTitle(incomeNoteDto.getNoteTitle());
             tmpNoteEntity.get().setCreateDate(incomeNoteDto.getCreateDate());
             tmpNoteEntity.get().setPriorityLevel(incomeNoteDto.getPriorityLevel());
           //note maintain body -http req-204

             //req-http://localhost:8080/note/api/v1/notes/NODE-f55ef5a3-0076-445a-99f1-2836294bbd82
             //{
             //    "noteTitle":"Sopet sevices",
             //    "noteDesc":"Pleace Come again!!",
             //    "priorityLevel":"P14",
             //    "createDate":"20240901"
             //
             //
             //}
             //resp-NoteDTO(noteId=null, noteTitle=Sopet sevices, noteDesc=Pleace Come again!!, priorityLevel=P14, createDate=20240901) Updated Successfully!!

         }




    }

    @Override
    public boolean deleteNote(String noteId) {

        //id is has or hasn't check
        //and check this id details has the db
        if (noteDAO.existsById(noteId)){
            noteDAO.deleteById(noteId);
            System.out.println("delete successfully!!");
            return true;
        }else {
            System.out.println("delete Unsuccessfully!!");
            return false;

        }



    }

    @Override
    public NoteResponse getSelectedNote(String noteId) {
        if (noteDAO.existsById(noteId)){
            return mapping.convertToDTO(noteDAO.getReferenceById(noteId));//converte to dto

        }else {
            return new NoteErrorResponse(0,"Note not found");
        }
        //unic consecrate -
        //NoteEntity selectedNode = noteDAO.getReferenceById(noteId); //return to note entity
        //req-http://localhost:8080/note/api/v1/notes/NODE-4f2221cd-266a-4b5e-a30e-95a501e02fd1
        //resp={
        //    "noteId": "NODE-4f2221cd-266a-4b5e-a30e-95a501e02fd1",
        //    "noteTitle": "Good luck!!",
        //    "noteDesc": "wshing your success",
        //    "priorityLevel": "P8",
        //    "createDate": 20240901
        //}


    }

    @Override
    public List<NoteDTO> getAllNotes() {
        //01
//        List<NoteEntity> getAllNotes = noteDAO.findAll(); //convert dto to entity
//        List<NoteDTO> noteDTOS = mapping.convertToDTO(getAllNotes);
//        return noteDTOS;

        //02
           return mapping.convertToDTO(noteDAO.findAll()); //converting
         //req -http://localhost:8080/note/api/v1/notes/allnotes
        //resp-mine type- Application json -object array ekk resp wenne = >> ym kisi code ekk code base ek pennann widiy literal ek
        // [{
        //        "noteId": "NODE-4f2221cd-266a-4b5e-a30e-95a501e02fd1",
        //        "noteTitle": "Good luck!!",
        //        "noteDesc": "wshing your success",
        //        "priorityLevel": "P8",
        //        "createDate": 20240901
        //    },]
        //how send json - //jackson databind dependency eken tamyi wenne - eken thamyi json convert krnne ek abstract   //  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    }

    //   @Override
 //   public void updateNote(String noteId,NoteDTO incomeNoteDTO) {
//        for (NoteDTO updateNote :saveNoteTmp){
//            if (updateNote.getNoteId().equals(noteId)){
//                updateNote.setNoteDesc(incomeNoteDTO.getNoteDesc());
//                updateNote.setNoteTitle(incomeNoteDTO.getNoteTitle());
//                updateNote.setPriorityLevel(incomeNoteDTO.getPriorityLevel());
//                updateNote.setCreateDate(incomeNoteDTO.getCreateDate());
//
//            }
//        }
//        ListIterator<NoteDTO> updateNote = saveNoteTmp.listIterator(); // object traver krnwa index eken adal ek return krnwa
//while (updateNote.hasNext()) { //hash -arry eke list size ek wenkm run wenwa
//    NoteDTO noteDTO = updateNote.next();
//    if (noteId.equals(noteDTO.getNoteId())) {
//        incomeNoteDTO.setNoteId(noteDTO.getNoteId());
//        updateNote.set(incomeNoteDTO);
  //      break; //while ek iwara unam break krnwa

        //req http://localhost:8080/note/api/v1/notes/NODE: f3473c8c-6cb9-4fd9-b2ec-94c357abafde
        //  resp-update get all check{
        //        "noteId": "NODE: f3473c8c-6cb9-4fd9-b2ec-94c357abafde",
        //        "noteTitle": "Sopet sevices",
        //        "noteDesc": "Hiii",
        //        "priorityLevel": "P3",
        //        "createDate": 20240818
        //    }
   // }
//}
 //   }

//    @Override
 //   public void deleteNote(String noteId) {
//        for (NoteDTO noteDTO :saveNoteTmp) {
//            if (noteDTO.getNoteId().equals(noteId)) {
//               saveNoteTmp.remove(noteDTO);
//            }
//        } //as a con current modification as a erro

//        ListIterator<NoteDTO> tmpList = saveNoteTmp.listIterator();
//        while (tmpList.hasNext()){
//            NoteDTO noteDTO = tmpList.next();
//            if (noteId.equals(noteDTO.getNoteId())){ //list eke tiyenm remove krnn
//                tmpList.remove();
//            }
//        }
  //  }

  //  @Override
 //   public NoteDTO getSelectedNote(String noteId) {
//        System.out.println(noteId);
//        for (NoteDTO noteDTO:saveNoteTmp){
//            if (noteDTO.getNoteId().equals(noteId)){
//                return noteDTO;
//            }
//        }
//       return null;
  //  }
//    @Override
//    public List<NoteDTO> getAllNotes() {
//        return saveNoteTmp;
//    }
}
//jpa -abstract tiyenne
//