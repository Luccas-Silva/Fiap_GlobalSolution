package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Integer> {
    List<Alerta> findBySensor_IdSensor(Integer idSensor);
}
