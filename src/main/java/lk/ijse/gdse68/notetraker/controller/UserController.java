package lk.ijse.gdse68.notetraker.controller;

import lk.ijse.gdse68.notetraker.dto.UserDTO;
import lk.ijse.gdse68.notetraker.service.UserService;
import lk.ijse.gdse68.notetraker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users") //rest full ekk -end point ek
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    //Save user
    //multipart form data- json concept- using file upload-req ek part widiyt enne ek body+header //large file upload krnn use we->using binary file handle
            @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)//client ge paththen req eddi ek ewanne consumes widiyt -ek server ek enne server ekt  //maltipar form data handle krnn use wenne //
                public ResponseEntity<String> saveUser(
                    //set parameter
                    //user client gen req enne multy part widiyt en ek dagnn tmyi  @RequestPart("firstName") use une
                    @RequestPart("firstName") String firstName,
                    @RequestPart("lastName") String lastName,
                    @RequestPart("email") String email,
                    @RequestPart("password") String password,
                    @RequestPart("profilePic") String profilePic) {

                //TODO:handle profile pic - //string widiyt save krgnne
                // saving to converting BASE64 ->> binary file converting to humon readable data

            String base64ProfilePic =  AppUtil.toBase64ProfilePic(profilePic); // base64 widiyt convete krnwa eke string ek return krnwa
            //bine the user object//pic save- link,base64,bite array widiyt save krnn puluwn binary files test widiyt db save krnn //bite-string convert //data trasfer krnn lesi -base64 -string widiyt enne

           UserDTO buildUserDTO = new UserDTO();
           buildUserDTO.setFirstName(firstName);
           buildUserDTO.setLastName(lastName);
           buildUserDTO.setEmail(email);
           buildUserDTO.setPassword(password);
           buildUserDTO.setProfilePic(base64ProfilePic);

           //send to the service layer
             return new ResponseEntity<>( userService.saveUser(buildUserDTO), HttpStatus.CREATED); //send msg and resp

  //req-http://localhost:8080/note/api/v1/users
   //set data - form data eke danne//pic ek file wlt denne
   //resp-User Save Successfully!!

            }

            //update user
    @PatchMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//            public ResponseEntity<String>updateUser(@PathVariable ("id") String id,UserDTO userDTO) {
//                userService.updateUser(id,userDTO);
//              boolean updateUserStatus = userService.updateUser(id, userDTO);
//                if (updateUserStatus) {
//                    return new ResponseEntity<>("User Update Successfully!!", HttpStatus.OK);
//                } else {
//                    return new ResponseEntity<>("User Update Failed!!", HttpStatus.INTERNAL_SERVER_ERROR);
//                }

                //req-http://localhost:8080/note/api/v1/users/USER-0b56f7ac-b5ea-4051-be70-31c64f87fdbf
        //resp-User Update Successfully!!
    public ResponseEntity<String> updateUser(
            @PathVariable ("id") String id,
            @RequestPart("updateFirstName") String updateFirstName,
            @RequestPart ("updateLastName") String updateLastName,
            @RequestPart ("updateEmail") String updateEmail,
            @RequestPart ("updatePassword") String updatePassword,
            @RequestPart ("updateProfilePic") String updateProfilePic
    ){
        String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(updateProfilePic);
        var updateUser = new UserDTO();
        updateUser.setUserId(id);
        updateUser.setFirstName(updateFirstName);
        updateUser.setLastName(updateLastName);
        updateUser.setPassword(updatePassword);
        updateUser.setEmail(updateEmail);
        updateUser.setProfilePic(updateBase64ProfilePic);
        return userService.updateUser(updateUser)? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//        boolean isUpdate = userService.updateUser(updateUser);
//
//        if (isUpdate) {
//            return new  ResponseEntity<>("User deleted successfully!!",HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        //    }

            //delete user

    //web service 2- representation and restfull and soft- //REST(representation state transfer)new ek - architecture ekk http protocol eken en method use krl client server architecture ekk widiyt data transfer krn ek
    //rest full - rest wl tiyen stranded tikk
    //web service 02
    //01.SOAP Web Services (WS-*): Web Services using Simple Object Access Protocol (SOAP), which is a messaging protocol based on XML. These services are often more formal and used in enterprise environments where robust standards (like security and transactions) are needed.
    //02.RESTful Web Services (Web 2.0 approach): Web services that use Representational State Transfer (REST), relying on standard HTTP methods (GET, POST, PUT, DELETE). REST services are commonly used in modern web applications due to their simplicity, scalability, and ease of use with JSON or XML formats.

    // DELETE mapping to delete a user by their id
    @DeleteMapping("/{id}") //path variable
    public ResponseEntity<String> deleteUser(@PathVariable ("id")String id) {
        // Call service to delete the user by id//resp-return 204
        //resp ek stander widiyt ywnn tmyi response states use krnne
        boolean isDeleted = userService.deleteUser(id);

        if (isDeleted) {
            return new  ResponseEntity<>("User deleted successfully!!",HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //req-http://localhost:8080/note/api/v1/users/USER-f4c124c9-c218-4438-93bc-a1a27cb25f1c
    //resp-User deleted successfully!!

    // get user
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        // Call service to get all users
        List<UserDTO> userDTOs = userService.getAllUsers();

        if (!userDTOs.isEmpty()) {
            return new ResponseEntity<>(userDTOs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //02-kramay
        //@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        //    public List<UserDTO> getAllUsers(){
        //        return userService.getAllUsers();
        //    }
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable ("id") String userId) {
        return userService.getSelectedUser(userId);

        //req-http://localhost:8080/note/api/v1/users/USER-0b56f7ac-b5ea-4051-be70-31c64f87fdbf
    }

}
