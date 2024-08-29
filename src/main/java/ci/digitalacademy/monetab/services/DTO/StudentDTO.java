package ci.digitalacademy.monetab.services.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data


public class StudentDTO extends PersonDTO {


    private String matricule;

    private String classe;
}
