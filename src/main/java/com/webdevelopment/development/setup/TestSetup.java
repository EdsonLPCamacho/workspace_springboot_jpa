package com.webdevelopment.development.setup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webdevelopment.development.entity.User;
import com.webdevelopment.development.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestSetup implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User usr = new User(null, "Paul", "paul@paul.com", "999999999");
		
		userRepository.saveAll(Arrays.asList(usr));
	}

}
