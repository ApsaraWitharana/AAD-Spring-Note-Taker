package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.dto.UserDTO;

import java.util.List;

public interface UserService {
    String saveUser(UserDTO userDTO);


    void updateUser(UserDTO userDTO);

    void deleteUser(String userId);
    UserDTO getSelectedUser(String usrId);


    List<UserDTO> getAllUsers();
}
