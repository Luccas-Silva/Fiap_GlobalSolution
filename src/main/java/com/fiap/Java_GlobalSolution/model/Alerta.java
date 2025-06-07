package com.fiap.Java_GlobalSolution.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
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

    @ManyToOne
    @JoinColumn(name = "idSensor")
    private Sensor sensor;

    public Alerta() {
    }
    public Alerta(Integer idAlerta, String nomeTipoAlerta, String descricaoTipoAlerta, Integer nivelGravidadeAlerta,
                  LocalDate dataGeracao, String mensagem, String statusAlerta, Double valorGatilho,
                  LocalDateTime dataInicioAtuacao, LocalDateTime dataFimAtuacao, String observacaoAtuacao,
                  AreaRisco areaRisco, EquipeResposta equipeResposta, Sensor sensor) {
        this.idAlerta = idAlerta;
        this.nomeTipoAlerta = nomeTipoAlerta;
        this.descricaoTipoAlerta = descricaoTipoAlerta;
        this.nivelGravidadeAlerta = nivelGravidadeAlerta;
        this.dataGeracao = dataGeracao;
        this.mensagem = mensagem;
        this.statusAlerta = statusAlerta;
        this.valorGatilho = valorGatilho;
        this.dataInicioAtuacao = dataInicioAtuacao;
        this.dataFimAtuacao = dataFimAtuacao;
        this.observacaoAtuacao = observacaoAtuacao;
        this.areaRisco = areaRisco;
        this.equipeResposta = equipeResposta;
        this.sensor = sensor;
    }

    public Integer getIdAlerta() {
        return idAlerta;
    }
    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getNomeTipoAlerta() {
        return nomeTipoAlerta;
    }
    public void setNomeTipoAlerta(String nomeTipoAlerta) {
        this.nomeTipoAlerta = nomeTipoAlerta;
    }

    public String getDescricaoTipoAlerta() {
        return descricaoTipoAlerta;
    }
    public void setDescricaoTipoAlerta(String descricaoTipoAlerta) {
        this.descricaoTipoAlerta = descricaoTipoAlerta;
    }

    public Integer getNivelGravidadeAlerta() {
        return nivelGravidadeAlerta;
    }
    public void setNivelGravidadeAlerta(Integer nivelGravidadeAlerta) {
        this.nivelGravidadeAlerta = nivelGravidadeAlerta;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }
    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatusAlerta() {
        return statusAlerta;
    }
    public void setStatusAlerta(String statusAlerta) {
        this.statusAlerta = statusAlerta;
    }

    public Double getValorGatilho() {
        return valorGatilho;
    }
    public void setValorGatilho(Double valorGatilho) {
        this.valorGatilho = valorGatilho;
    }

    public LocalDateTime getDataInicioAtuacao() {
        return dataInicioAtuacao;
    }
    public void setDataInicioAtuacao(LocalDateTime dataInicioAtuacao) {
        this.dataInicioAtuacao = dataInicioAtuacao;
    }

    public LocalDateTime getDataFimAtuacao() {
        return dataFimAtuacao;
    }
    public void setDataFimAtuacao(LocalDateTime dataFimAtuacao) {
        this.dataFimAtuacao = dataFimAtuacao;
    }

    public String getObservacaoAtuacao() {
        return observacaoAtuacao;
    }
    public void setObservacaoAtuacao(String observacaoAtuacao) {
        this.observacaoAtuacao = observacaoAtuacao;
    }

    public AreaRisco getAreaRisco() {
        return areaRisco;
    }
    public void setAreaRisco(AreaRisco areaRisco) {
        this.areaRisco = areaRisco;
    }

    public EquipeResposta getEquipeResposta() {
        return equipeResposta;
    }
    public void setEquipeResposta(EquipeResposta equipeResposta) {
        this.equipeResposta = equipeResposta;
    }

    public Sensor getSensor() {return sensor;}
    public void setSensor(Sensor sensor) {this.sensor = sensor;}

    @Override
    public String toString() {
        return "Alerta{" +
                "idAlerta=" + idAlerta +
                ", nomeTipoAlerta='" + nomeTipoAlerta + '\'' +
                ", descricaoTipoAlerta='" + descricaoTipoAlerta + '\'' +
                ", nivelGravidadeAlerta=" + nivelGravidadeAlerta +
                ", dataGeracao=" + dataGeracao +
                ", mensagem='" + mensagem + '\'' +
                ", statusAlerta='" + statusAlerta + '\'' +
                ", valorGatilho=" + valorGatilho +
                ", dataInicioAtuacao=" + dataInicioAtuacao +
                ", dataFimAtuacao=" + dataFimAtuacao +
                ", observacaoAtuacao='" + observacaoAtuacao + '\'' +
                ", areaRisco=" + (areaRisco != null ? areaRisco.getIdAreaRisco() : null) +
                ", equipeResposta=" + (equipeResposta != null ? equipeResposta.getIdEquipe() : null) +
                '}';
    }
}
