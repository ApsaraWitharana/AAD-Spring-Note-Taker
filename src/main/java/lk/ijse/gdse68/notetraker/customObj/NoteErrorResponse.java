package lk.ijse.gdse68.notetraker.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteErrorResponse implements NoteResponse, Serializable {
    private int errorCode;
    private String errorMassage;
}

//middle where project wl use krnw  = front end,backend ekt mding taw ekk e kiyne java backend ekk ekk tw python backend ekk use unot mew danwa ethkot python backend ekt ywnne resp /req ek t me erro code ek ywnnn one
