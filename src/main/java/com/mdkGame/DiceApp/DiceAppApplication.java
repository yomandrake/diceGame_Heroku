package com.mdkGame.DiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.mdkGame.DiceApp.Security.UserRepository;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiceAppApplication.class, args);
	}
	

}
