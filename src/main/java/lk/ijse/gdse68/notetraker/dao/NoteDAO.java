package lk.ijse.gdse68.notetraker.dao;

import lk.ijse.gdse68.notetraker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // component dnn one na ek auto connect wenwa //e class ek repository ekk widiyt repo krnwa database ekk widiyt /
public interface NoteDAO extends JpaRepository<NoteEntity,String> { //entity type and primary key eke data type ek pass krnwa//(raper ek primitive unot ek rapper ekk danne int,double wage ewat
}
