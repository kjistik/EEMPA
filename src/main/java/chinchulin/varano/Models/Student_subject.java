package chinchulin.varano.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student_subject")
public class Student_subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student-subject_id")
    Long student_subject_Id;

    @Column(name = "student_id")
    Long student_id;

    @Column(name = "subject_id")
    Long subject_id;

    @JsonBackReference(value = "califications")
    @OneToMany(mappedBy = "student_subject")
    List<Calification> califications;
}
