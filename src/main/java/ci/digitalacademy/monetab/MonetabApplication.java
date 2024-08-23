package ci.digitalacademy.monetab;

import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.AdressService;
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

	public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null,"Bakus","azerty", Instant.now(),null);
		Adress adress = new Adress(null,"Côte d'ivoire","Abidjan", "Cocody");
		userService.save(user);
		adressService.save(adress);
		List<User>users = userService.findAll();
		List<Adress>adresse = adressService.findAll();
		System.out.println(user);
		System.out.println(adress);
	}
}
