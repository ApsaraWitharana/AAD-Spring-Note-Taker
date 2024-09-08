package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.customObj.UserResponse;
import lk.ijse.gdse68.notetraker.dto.iml.UserDTO;

import java.util.List;

public interface UserService {
    String saveUser(UserDTO userDTO);


    void updateUser(UserDTO userDTO);

    void deleteUser(String userId);
    UserResponse getSelectedUser(String usrId);


    List<UserDTO> getAllUsers();
}
