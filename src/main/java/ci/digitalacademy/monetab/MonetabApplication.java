package ci.digitalacademy.monetab;

import ci.digitalacademy.monetab.models.*;
import ci.digitalacademy.monetab.services.AdressService;
import ci.digitalacademy.monetab.services.DTO.StudentDTO;
import ci.digitalacademy.monetab.services.FicheNoteService;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private AdressService adressService;
	@Autowired
	private FicheNoteService ficheNoteService;
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User(null,"admin","admin", Instant.now(),null);

		StudentDTO student1 = new StudentDTO();
		student1.setNom("koffi");
		student1.setPrenom("paul");
		student1.setClasse("L1");
		student1.setAge("2024-08-08");
		student1.setTel("0140101616");
		student1.setGenre("M");
		student1.setMatricule("225ABJ");
		student1.setDateCreation(Instant.now());
		studentService.save(student1);

		StudentDTO student2 = new StudentDTO();
		student2.setNom("Soro");
		student2.setPrenom("Marc");
		student2.setClasse("L1");
		student2.setAge("2024-08-08");
		student2.setTel("0140101016");
		student2.setGenre("M");
		student2.setMatricule("225ABJ");
		student2.setDateCreation(Instant.now());
		studentService.save(student2);
		userService.save(user);

		//Teacher teacher = new Teacher();
		//List<User>users = userService.findAll();
		//List<Adress>adresse = adressService.findAll();
		//List<FicheNote>ficheNotes = ficheNoteService.findAll();
		System.out.println(user);

	}
}
