package lk.ijse.gdse68.notetraker.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class AppUtil {

    public static String createNoteId(){
        return "NODE-" + UUID.randomUUID();
    }
    //entitiy dto - dto entitiy
    //TODO :mapping
    //TODO :Note details
}

