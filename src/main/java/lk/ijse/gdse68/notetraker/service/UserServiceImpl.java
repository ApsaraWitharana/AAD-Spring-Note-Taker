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
import java.util.List;
import java.util.Optional;

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
        UserEntity savedUser = userDAO.save(mapping.convertToUserEntity(userDTO));//pass krnw dao layer ekt //ek mapp krl dto convert krnw entity widiyt it passe ek db ekt pass krnw
        if (savedUser != null && savedUser.getUserId() !=null){
            return "User Save Successfully!!";
        }else {
            return "User Save UnSuccessfully!!";
        }

    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDAO.findById(userDTO.getUserId());
        if(!tmpUser.isPresent()){
            return false;
        }else {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
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
       UserEntity userEntityByUserId =userDAO.getUserEntityByUserId(usrId);
       return mapping.convertToUserDTO(userEntityByUserId);
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

        // 02 -kramay
        // @Override
        //    public List<UserDTO> getAllUsers() {
        //        -return List.of();
        //        List<UserEntity> getAllUsers = userDao.findAll();
        //        return mapping.convertUserToDTOList(getAllUsers);
        //    }
    }
    //req-http://localhost:8080/note/api/v1/users
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
//204-no data