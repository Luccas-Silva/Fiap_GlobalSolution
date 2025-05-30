package com.fiap.Java_GlobalSolution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AreaRisco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaRisco;

    private String nomeArea;
    private String tipoRisco;
    private Double latitude;
    private Double longitude;
    private String descricao;
    private String statusArea;

    @OneToMany(mappedBy = "areaDeRisco")
    private List<Sensor> sensores;

    @OneToMany(mappedBy = "areaDeRisco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertas;
}
