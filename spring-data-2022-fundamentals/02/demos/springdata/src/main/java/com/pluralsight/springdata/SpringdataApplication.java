package com.pluralsight.springdata;

import com.pluralsight.springdata.model.User;
import com.pluralsight.springdata.repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class SpringdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Bean
	public ApplicationRunner configure(UserRepository repository) {
		return env -> {
            User user1 = new User("beth", LocalDate.of(2023, Month.JANUARY, 15));
			User user2 = new User("mike", LocalDate.of(2023, Month.MARCH, 15));

			repository.save(user1);
			repository.save(user2);

			repository.findAll().forEach(System.out::println);
		};
	}

}
