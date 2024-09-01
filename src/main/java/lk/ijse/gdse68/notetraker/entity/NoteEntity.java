package lk.ijse.gdse68.notetraker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "noteTraker")
@Entity
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    //entity eke user ge details
    @ManyToOne
    //map-note user mapping to colom - note godk ek uset tiyen puluwn ek map krn join
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private Long createDate;

}
