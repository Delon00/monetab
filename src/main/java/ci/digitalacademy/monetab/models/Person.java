package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "person_type")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="lastname", nullable = false)
    private String nom;
    @Column(name ="firstname",nullable = false)
    private String prenom;
    @Column(name = "telephone", nullable = false)
    private String tel;
    @Column(nullable=false)
    private String age;
    @Column(nullable = false)
    private String genre;
    @Column(nullable=false)
    private Instant dateCreation;
}
