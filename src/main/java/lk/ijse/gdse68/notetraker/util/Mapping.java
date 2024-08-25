package lk.ijse.gdse68.notetraker.util;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;
import lk.ijse.gdse68.notetraker.entity.NoteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //matter of noteEntity and DTO
    public NoteDTO convertToDTO(NoteEntity note){ //entity type dto ek converte krnwa dto ekt
        return modelMapper.map(note,NoteDTO.class); //entity to dto converting
    }
    public NoteEntity convertToDTO(NoteDTO dto){ //entity type dto ek converte krnwa dto ekt
        return modelMapper.map(dto,NoteEntity.class); //entity to dto converting
    }

    public List<NoteDTO> convertToDTO(List<NoteEntity>notes){ //create dto list and convert to entity list
        return modelMapper.map(notes, List.class);
    }
}
