package com.SpringGame.DicesGame_JPA;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SpringGame.DicesGame_JPA.Statics.StaticsService;

@SpringBootApplication
public class DicesGameJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicesGameJpaApplication.class, args);
	}
	
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Bean
    public StaticsService StaticsService() {
        return new StaticsService();
    }
    
}
