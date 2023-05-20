package de.farzaneh.simpledev;

import de.farzaneh.simpledev.model.Location;
import de.farzaneh.simpledev.model.User;
import de.farzaneh.simpledev.repository.LocationRepository;
import de.farzaneh.simpledev.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleDevApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDevApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		Location location = new Location();
		location.setPlace("Pune");
		location.setDescription("Pune is great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location); //save in db

		User user1 = new User();
		user1.setFirstName("farzaneh");
		user1.setLastName("amiri");
		user1.setEmail("famiri82@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("Ryan");
		user2.setLastName("dan");
		user2.setEmail("frdan@gmail.com");
		user2.setPassword("secret");
		user2.setLocation(location);
		userRepository.save(user2);
	}

}
