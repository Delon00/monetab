package ci.digitalacademy.monetab.services.DTO;

import ci.digitalacademy.monetab.models.Teacher;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.time.Instant;
@Data
@Slf4j

public class FicheNoteDTO {
    private Long id;


    private String note;

    private String annee;

    private Instant dateCreation;

    private Teacher teacher;
}
