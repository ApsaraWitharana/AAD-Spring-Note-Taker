package lk.ijse.gdse68.notetraker.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserErrorResponse implements UserResponse{
    private int errorCode;
    private String errorMassage;
}
