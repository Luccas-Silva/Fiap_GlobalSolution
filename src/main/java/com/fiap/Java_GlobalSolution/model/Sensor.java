package com.fiap.Java_GlobalSolution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSensor;

    private String tipoSensor;
    private String marca;
    private String localizacao;
    private String unidadeMedida;
    private LocalDate dataInstalacao;
    private String statusSensor;
    private Double valorLidoSensor;
    private LocalDateTime dataHoraLeituraSensor;

    @ManyToOne
    @JoinColumn(name = "idAreaRisco")
    private AreaRisco areaRisco;
}
