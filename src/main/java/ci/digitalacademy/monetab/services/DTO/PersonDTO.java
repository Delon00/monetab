package ci.digitalacademy.monetab.services.DTO;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
@Data
@Slf4j
public class PersonDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String tel;

    private String age;

    private String genre;

    private Instant dateCreation;
}
