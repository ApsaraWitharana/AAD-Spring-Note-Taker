package lk.ijse.gdse68.notetraker.controller;

import lk.ijse.gdse68.notetraker.dto.NoteDTO;
import lk.ijse.gdse68.notetraker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
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

            }

}
