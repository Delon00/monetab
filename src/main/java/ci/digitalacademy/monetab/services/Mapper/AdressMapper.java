package ci.digitalacademy.monetab.services.Mapper;
import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.services.DTO.AdressDTO;


public final class AdressMapper {
    private AdressMapper() {
    }

    public static AdressDTO toDto(Adress address) {
        AdressDTO addressDTO = new AdressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }

    public static Adress toEntity(AdressDTO adressDTO) {
        Adress address = new Adress();
        address.setId(adressDTO.getId());
        address.setCity(adressDTO.getCity());
        address.setStreet(adressDTO.getStreet());
        address.setCountry(adressDTO.getCountry());
        return address;
    }

}