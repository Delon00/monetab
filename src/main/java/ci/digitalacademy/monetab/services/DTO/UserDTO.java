package ci.digitalacademy.monetab.services.DTO;

import ci.digitalacademy.monetab.models.Adress;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.time.Instant;
@Slf4j
@Data

public class UserDTO {

    private Long id;


    private String pseudo;


    private String password;

    private Instant dateCreation;


    private Adress adress;
}
