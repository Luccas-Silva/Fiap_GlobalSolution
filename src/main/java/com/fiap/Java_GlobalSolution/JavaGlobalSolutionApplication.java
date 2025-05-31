package com.fiap.Java_GlobalSolution;

import com.fiap.Java_GlobalSolution.model.*;
import com.fiap.Java_GlobalSolution.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class JavaGlobalSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGlobalSolutionApplication.class, args);
	}



}
