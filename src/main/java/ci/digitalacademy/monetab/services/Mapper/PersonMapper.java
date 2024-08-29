package ci.digitalacademy.monetab.services.Mapper;

import ci.digitalacademy.monetab.models.Person;
import ci.digitalacademy.monetab.services.DTO.PersonDTO;

public class PersonMapper {
    private PersonMapper() {
    }

    public static PersonDTO toDto(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setNom(person.getNom());
        personDTO.setPrenom(person.getPrenom());
        personDTO.setTel(person.getTel());
        personDTO.setAge(person.getAge());
        personDTO.setGenre(person.getGenre());
        personDTO.setDateCreation(person.getDateCreation());
        return personDTO;
    }

    public static Person toEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setNom(personDTO.getNom());
        person.setPrenom(personDTO.getPrenom());
        person.setTel(personDTO.getTel());
        person.setAge(personDTO.getAge());
        person.setGenre(personDTO.getGenre());
        person.setDateCreation(personDTO.getDateCreation());
        return person;
    }
}
