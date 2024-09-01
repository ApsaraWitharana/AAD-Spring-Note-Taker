package lk.ijse.gdse68.notetraker.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    public static String createNoteId(){
        return "NODE-" + UUID.randomUUID();
    }
    //entitiy dto - dto entitiy
    //TODO :mapping
    //TODO :Note details

    public static String createUserId(){
        return "USER-" + UUID.randomUUID();
    }

    public static String toBase64ProfilePic(String profilePic){
        return Base64.getEncoder().encodeToString(profilePic.getBytes()); // create base64 reference this is utility class ,getEncoder()->>string ek base64 ekt harawanwa getDecoder()--apit ona ek widiyt danwa, encodeToString(profilePic.getBytes()-base64 ekt ape string ek convert krnwa apit one wen byte ek pass krnne

    }
}

