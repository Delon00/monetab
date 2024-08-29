package ci.digitalacademy.monetab.models;



import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Data
@NoArgsConstructor
//@DiscriminatorValue(value = "teacher")
public class Teacher extends Person {

    @Column(nullable = false)
    private String matiere;

    @Column(nullable = false)
    private boolean vacant;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "teacher")
    private Set<FicheNote> ficheNote;
}
