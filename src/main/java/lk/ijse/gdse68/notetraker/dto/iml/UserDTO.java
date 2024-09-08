package lk.ijse.gdse68.notetraker.dto.iml;

import lk.ijse.gdse68.notetraker.customObj.UserResponse;
import lk.ijse.gdse68.notetraker.dto.SuperDTO;
import lk.ijse.gdse68.notetraker.dto.iml.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements SuperDTO, UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteDTO> notes = new ArrayList<>();
}
