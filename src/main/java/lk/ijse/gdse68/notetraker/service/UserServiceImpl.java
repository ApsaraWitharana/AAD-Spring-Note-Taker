package lk.ijse.gdse68.notetraker.service;

import lk.ijse.gdse68.notetraker.dao.UserDAO;
import lk.ijse.gdse68.notetraker.dto.UserDTO;
import lk.ijse.gdse68.notetraker.entity.UserEntity;
import lk.ijse.gdse68.notetraker.util.AppUtil;
import lk.ijse.gdse68.notetraker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserDAO userDAO;
    @Autowired
    private final Mapping mapping ;



    @Override
    public String saveUser(UserDTO userDTO) {
    userDTO.setUserId(AppUtil.createUserId());//id generate
   userDAO.save(mapping.convertToUserEntity(userDTO));//pass krnw dao layer ekt //ek mapp krl dto convert krnw entity widiyt it passe ek db ekt pass krnw
   return "User Save Successfully!!";
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
// First, retrieve the existing user entity from the database
        UserEntity existingUser = (UserEntity) userDAO.findAllById(Collections.singleton(userId));

        // If the user is not found, return false
        if (existingUser == null) {
            return false;
        }

        // Update the existing user entity with the new data from the DTO
        existingUser.setUserId(userDTO.getUserId());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setProfilePic(userDTO.getProfilePic());
        // ... update other fields as needed

        // Save the updated user entity to the database
        userDAO.save(existingUser);

        // Return true to indicate that the update was successful
        return true;
    }

    @Override
    public boolean deleteUser(String userId) {
            if (userDAO.existsById(userId)) {
               userDAO.deleteById(userId);
                return true;
            } else {
                return false; // User doesn't exist
            }
        }


    @Override
    public UserDTO getSelectedUser(String usrId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // Assuming you have a database connection and a User entity
        List<UserEntity> users = userDAO.findAll(); // or a similar method to fetch all users

        // Convert the list of User entities to a list of UserDTOs
        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserEntity userEntity : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userEntity.getUserId());
            userDTO.setFirstName(userEntity.getFirstName());
            userDTO.setLastName(userEntity.getLastName());
            userDTO.setPassword(userEntity.getPassword());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setProfilePic(userEntity.getProfilePic());
            // Add other fields as needed
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }
    //req-http://localhost:8080/note/api/v1/users/USER-0b56f7ac-b5ea-4051-be70-31c64f87fdbf
    //resp-[
    //    {
    //        "userId": "USER-0b56f7ac-b5ea-4051-be70-31c64f87fdbf",
    //        "firstName": "Sachini",
    //        "lastName": "Apsara",
    //        "email": "asachi@gmail.com",
    //        "password": "1234",
    //        "profilePic": "/9j/4AAQSkZJRgABAQAAAQABAAD/
    //]
}

//500 - internal server error
//404 -
//201-created -res full