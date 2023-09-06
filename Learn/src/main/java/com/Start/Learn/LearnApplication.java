package com.Start.Learn;

import com.Start.Learn.entity.Account;
import com.Start.Learn.repositories.AccountRepository;
import com.Start.Learn.util.AccountFaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LearnApplication implements CommandLineRunner {
	@Autowired
	AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Account> accounts = new ArrayList<>();
		for(Long n = 0L; n < 15; n++){
			accounts.add( new Account(0L,
					AccountFaker.createFakeAccount().getFirstName(),
					AccountFaker.createFakeAccount().getLastName(),
					AccountFaker.createFakeAccount().getPhoneNumber(),
					AccountFaker.createFakeAccount().getEmail(),
					AccountFaker.createFakeAccount().getPassword(),
					AccountFaker.createFakeAccount().getRole()));
		}
//		accountRepository.saveAll(accounts);
	}
}
