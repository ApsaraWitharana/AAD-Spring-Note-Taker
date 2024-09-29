package lk.ijse.gdse68.notetraker.util;

import lk.ijse.gdse68.notetraker.dto.iml.NoteDTO;
import lk.ijse.gdse68.notetraker.dto.iml.UserDTO;
import lk.ijse.gdse68.notetraker.entity.NoteEntity;
import lk.ijse.gdse68.notetraker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
//why using modelmapper - db eke data save and get krnn mape krgnn thamyi use wenne dto converting entity and entity convert dto
    //matter of noteEntity and DTO
    public NoteDTO convertToDTO(NoteEntity note){ //entity type dto ek converte krnwa dto ekt
        return modelMapper.map(note,NoteDTO.class); //entity to dto converting
    }
    public NoteEntity convertToEntity(NoteDTO dto){ //entity type dto ek converte krnwa dto ekt
        return modelMapper.map(dto,NoteEntity.class); //entity to dto converting
    }

    public List<NoteDTO> convertToDTO(List<NoteEntity> noteEntities) {
        return modelMapper.map(noteEntities, new TypeToken<List<NoteDTO>>() {}.getType());
    }

//    public List<NoteDTO> convertToDTO(List<NoteEntity> notes) { //create dto list and convert to entity list
//        return modelMapper.map(notes, List.class); //
//    }

    //TODO: USER MAPPING
    //User matters mapping
    public UserEntity convertToUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO convertToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> convertUserToDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
    }
}
