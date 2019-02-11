package com.example.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.User;
import com.example.cardatabase.repository.CarRepository;
import com.example.cardatabase.repository.OwnerRepository;
import com.example.cardatabase.repository.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	// For demo data and jpa only
	// Remove when other components are added
	@Autowired
	private CarRepository carRepo;
	@Autowired
	private OwnerRepository ownerRepo;
	@Autowired
	private UserRepository urepository;
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Add owner objects and save these to db
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			ownerRepo.save(owner1);
			ownerRepo.save(owner2);
			// Add car object with link to owners and save these to db.
			Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			carRepo.save(car);
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			carRepo.save(car);
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			carRepo.save(car);
			// username: user password: user
			urepository.save(new User("user",
			"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
			"USER"));
			// username: admin password: admin
			urepository.save(new User("admin",
			"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
			"ADMIN"));
		};
	}
}
