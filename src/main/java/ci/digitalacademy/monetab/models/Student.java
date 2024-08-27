package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

//@DiscriminatorValue(value = "student")
public class Student extends Person {

    @Column(nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String classe;
}
