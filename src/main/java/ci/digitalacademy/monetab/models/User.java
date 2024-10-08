package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pseudo",unique = true,nullable = false)
    private String pseudo;

    @Column(nullable = false)
    private String password;

    @Column(name = "creationDate",nullable = false )
    private Instant dateCreation;


    @JoinColumn(name = "adressId")
    @OneToOne
    private Adress adress;

}
