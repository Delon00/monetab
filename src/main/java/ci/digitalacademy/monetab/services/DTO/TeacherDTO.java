package ci.digitalacademy.monetab.services.DTO;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data


public class TeacherDTO extends PersonDTO{

    private String matiere;

    private boolean vacant;

}
