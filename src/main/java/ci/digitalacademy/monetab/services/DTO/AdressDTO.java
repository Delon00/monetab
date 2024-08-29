package ci.digitalacademy.monetab.services.DTO;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j

public class AdressDTO {

    private Long id;
    private String country;
    private String city;
    private String street;
}
