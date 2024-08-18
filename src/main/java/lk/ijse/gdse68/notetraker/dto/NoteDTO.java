package lk.ijse.gdse68.notetraker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements Serializable {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private Long createDate;


    public NoteDTO(String noteId, String restServices, String explainTheRest, String p1, String number) {
    }
}
