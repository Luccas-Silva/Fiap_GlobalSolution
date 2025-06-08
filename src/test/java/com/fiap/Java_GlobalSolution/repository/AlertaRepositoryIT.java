package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.Alerta;
import com.fiap.Java_GlobalSolution.model.Sensor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlertaRepositoryIT {

    @Autowired
    private AlertaRepository alertaRepository;
    @Autowired
    private SensorRepository sensorRepository;

    @Test
    void deveBuscarAlertasPorSensorId() {
        Sensor sensor = Sensor.builder()
                .tipoSensor("Temperatura")
                .build();
        sensor = sensorRepository.save(sensor);

        Alerta alerta = Alerta.builder()
                .nomeTipoAlerta("Alerta de Teste")
                .sensor(sensor)
                .dataGeracao(LocalDate.now())
                .build();
        alertaRepository.save(alerta);

        List<Alerta> alertas = alertaRepository.findBySensor_IdSensor(sensor.getIdSensor());
        assertFalse(alertas.isEmpty());
        assertEquals(sensor.getIdSensor(), alertas.get(0).getSensor().getIdSensor());
    }
}