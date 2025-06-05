package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer>{
}
