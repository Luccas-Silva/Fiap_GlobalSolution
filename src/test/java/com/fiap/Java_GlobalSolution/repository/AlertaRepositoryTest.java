package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.Alerta;
import com.fiap.Java_GlobalSolution.model.Sensor;
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
        when(repo.findBySensor_IdSensor(idSensor)).thenReturn(List.of(
                Alerta.builder().idAlerta(1).dataGeracao(LocalDate.now()).build()
        ));

        List<Alerta> alertas = repo.findBySensor_IdSensor(idSensor);
        assertFalse(alertas.isEmpty());
        verify(repo).findBySensor_IdSensor(idSensor);
    }
}