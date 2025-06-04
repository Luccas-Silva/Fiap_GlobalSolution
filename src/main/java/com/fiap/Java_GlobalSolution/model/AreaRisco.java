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

    @OneToMany(mappedBy = "areaRisco")
    private List<Sensor> sensores;

    @OneToMany(mappedBy = "areaRisco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertas;

    public AreaRisco() {
    }
    public AreaRisco(Integer idAreaRisco, String nomeArea, String tipoRisco, Double latitude, Double longitude,
                     String descricao, String statusArea, List<Sensor> sensores, List<Alerta> alertas) {
        this.idAreaRisco = idAreaRisco;
        this.nomeArea = nomeArea;
        this.tipoRisco = tipoRisco;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
        this.statusArea = statusArea;
        this.sensores = sensores;
        this.alertas = alertas;
    }

    public Integer getIdAreaRisco() {
        return idAreaRisco;
    }
    public void setIdAreaRisco(Integer idAreaRisco) {
        this.idAreaRisco = idAreaRisco;
    }

    public String getNomeArea() {
        return nomeArea;
    }
    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public String getTipoRisco() {
        return tipoRisco;
    }
    public void setTipoRisco(String tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusArea() {
        return statusArea;
    }
    public void setStatusArea(String statusArea) {
        this.statusArea = statusArea;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }
    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }
    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    @Override
    public String toString() {
        return "AreaRisco{" +
                "idAreaRisco=" + idAreaRisco +
                ", nomeArea='" + nomeArea + '\'' +
                ", tipoRisco='" + tipoRisco + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", descricao='" + descricao + '\'' +
                ", statusArea='" + statusArea + '\'' +
                ", sensores=" + (sensores != null ? sensores.size() : null) +
                ", alertas=" + (alertas != null ? alertas.size() : null) +
                '}';
    }

}
