package ci.digitalacademy.monetab.models;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Teacher extends Person {


    @Column(nullable = false)
    private String matiere;


}
