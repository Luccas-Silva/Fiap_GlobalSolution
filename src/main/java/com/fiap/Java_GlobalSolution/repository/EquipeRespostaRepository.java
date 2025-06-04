package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.EquipeResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipeRespostaRepository extends JpaRepository<EquipeResposta, Integer> {
    @Query("SELECT DISTINCT e FROM EquipeResposta e LEFT JOIN FETCH e.alertas")
    List<EquipeResposta> findAllWithAlertas();

}
