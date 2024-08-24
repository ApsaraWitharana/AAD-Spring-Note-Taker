package lk.ijse.gdse68.notetraker.util;

import java.util.UUID;

public class AppUtil {
    public static String createNoteId(){
        return "NODE: " + UUID.randomUUID();
    }
}

