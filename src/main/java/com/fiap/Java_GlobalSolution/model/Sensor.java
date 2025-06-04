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

    public Sensor() {
    }
    public Sensor(Integer idSensor, String tipoSensor, String marca, String localizacao, String unidadeMedida,
                  LocalDate dataInstalacao, String statusSensor, Double valorLidoSensor,
                  LocalDateTime dataHoraLeituraSensor, AreaRisco areaRisco) {
        this.idSensor = idSensor;
        this.tipoSensor = tipoSensor;
        this.marca = marca;
        this.localizacao = localizacao;
        this.unidadeMedida = unidadeMedida;
        this.dataInstalacao = dataInstalacao;
        this.statusSensor = statusSensor;
        this.valorLidoSensor = valorLidoSensor;
        this.dataHoraLeituraSensor = dataHoraLeituraSensor;
        this.areaRisco = areaRisco;
    }

    public Integer getIdSensor() {
        return idSensor;
    }
    public void setIdSensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }
    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }
    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getStatusSensor() {
        return statusSensor;
    }
    public void setStatusSensor(String statusSensor) {
        this.statusSensor = statusSensor;
    }

    public Double getValorLidoSensor() {
        return valorLidoSensor;
    }
    public void setValorLidoSensor(Double valorLidoSensor) {
        this.valorLidoSensor = valorLidoSensor;
    }

    public LocalDateTime getDataHoraLeituraSensor() {
        return dataHoraLeituraSensor;
    }
    public void setDataHoraLeituraSensor(LocalDateTime dataHoraLeituraSensor) {
        this.dataHoraLeituraSensor = dataHoraLeituraSensor;
    }

    public AreaRisco getAreaRisco() {
        return areaRisco;
    }
    public void setAreaRisco(AreaRisco areaRisco) {
        this.areaRisco = areaRisco;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "idSensor=" + idSensor +
                ", tipoSensor='" + tipoSensor + '\'' +
                ", marca='" + marca + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", dataInstalacao=" + dataInstalacao +
                ", statusSensor='" + statusSensor + '\'' +
                ", valorLidoSensor=" + valorLidoSensor +
                ", dataHoraLeituraSensor=" + dataHoraLeituraSensor +
                ", areaRisco=" + (areaRisco != null ? areaRisco.getIdAreaRisco() : null) +
                '}';
    }

}
