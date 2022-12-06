package com.javaricci.FolhaSpringBootSecurity;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//https://springjava.com/spring-boot/entity-to-dto-on-spring-boot-rest-api

@SpringBootApplication
public class FolhaSpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FolhaSpringBootSecurityApplication.class, args);
                //Gerar senha criptografada no terminal quando iniciar o Sprig Boot
                //System.out.println(new BCryptPasswordEncoder().encode("senha@123"));
	}

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();

	}

}
