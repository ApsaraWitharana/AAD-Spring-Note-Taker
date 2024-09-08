package lk.ijse.gdse68.notetraker.dto.iml;

import lk.ijse.gdse68.notetraker.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements SuperDTO {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private Long createDate;
    private String userId;


    public NoteDTO(String noteId, String restServices, String explainTheRest, String p1, String number) {
    }
}
