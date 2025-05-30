package com.fiap.Java_GlobalSolution;

import com.fiap.Java_GlobalSolution.model.Sensor;
import com.fiap.Java_GlobalSolution.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class JavaGlobalSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGlobalSolutionApplication.class, args);
	}

	@Bean
	public CommandLineRunner Senso(SensorRepository sensorRepository) {
		return args -> {
			Sensor sensor = Sensor.builder()
					.tipoSensor("Temperatura")
					.marca("Acme")
					.localizacao("Sala 1")
					.unidadeMedida("Celsius")
					.dataInstalacao(LocalDate.now())
					.statusSensor("Ativo")
					.valorLidoSensor(22.5)
					.dataHoraLeituraSensor(LocalDateTime.now())
					.areaRisco(null) // defina uma área de risco válida se necessário
					.build();

			sensorRepository.save(sensor);
			System.out.println("Sensor inicial salvo!");
		};
	}

}
