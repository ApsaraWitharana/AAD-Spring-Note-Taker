package lk.ijse.gdse68.notetraker.controller;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;
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
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    //Save user
    //multipart form data- json concept- using file upload
            @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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
            //bine the user object

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

}
