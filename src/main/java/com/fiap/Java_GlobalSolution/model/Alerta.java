package com.fiap.Java_GlobalSolution.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlerta;

    private String nomeTipoAlerta;
    private String descricaoTipoAlerta;
    private Integer nivelGravidadeAlerta;
    private LocalDate dataGeracao;
    private String mensagem;
    private String statusAlerta;
    private Double valorGatilho;
    private LocalDateTime dataInicioAtuacao;
    private LocalDateTime dataFimAtuacao;
    private String observacaoAtuacao;

    @ManyToOne
    @JoinColumn(name = "idAreaRisco")
    private AreaRisco areaRisco;

    @ManyToOne
    @JoinColumn(name = "idEquipe")
    private EquipeResposta equipeResposta;
}
