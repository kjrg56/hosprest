package com.kraytech.restdemo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kraytech.restdemo.repositories.MedicoRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	public CommandLineRunner initDatabase(MedicoRepository repo) {
		return args -> {
			log.info("Aquí se pueden inicializar cosas jeje.");
		};
	}
	
}
