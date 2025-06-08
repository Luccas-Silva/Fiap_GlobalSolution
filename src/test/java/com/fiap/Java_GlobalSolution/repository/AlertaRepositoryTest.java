package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.Alerta;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlertaRepositoryTest {

    @Test
    void deveChamarFindBySensor_IdSensor() {
        AlertaRepository repo = mock(AlertaRepository.class);
        int idSensor = 1;
        Alerta alerta = new Alerta();
        alerta.setIdAlerta(1);
        alerta.setDataGeracao(LocalDate.now());
        when(repo.findBySensor_IdSensor(idSensor)).thenReturn(List.of(alerta));

        List<Alerta> alertas = repo.findBySensor_IdSensor(idSensor);
        assertFalse(alertas.isEmpty());
        verify(repo).findBySensor_IdSensor(idSensor);
    }
}