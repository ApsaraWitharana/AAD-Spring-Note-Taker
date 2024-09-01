package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.dao.NoteDAO;
import lk.ijse.gdse68.notetraker.dao.UserDAO;
import lk.ijse.gdse68.notetraker.dto.UserDTO;
import lk.ijse.gdse68.notetraker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Mapping mapping;


    @Override
    public String saveUser(UserDTO userDTO) {

    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public UserDTO getSelectedUser(String usrId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }
}
