package com.fiap.Java_GlobalSolution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
public class EquipeResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;

    private String nomeEquipe;
    private String areaAtuacao;
    private String contato;

    @ManyToMany
    @JoinTable(name = "equipe_resposta_usuario",
            joinColumns = @JoinColumn(name = "idEquipe"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario"))
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "equipeResposta")
    private List<Alerta> alertas = new ArrayList<>();

    public EquipeResposta() {
    }
    public EquipeResposta(Integer idEquipe, String nomeEquipe, String areaAtuacao, String contato, List<Usuario> usuarios, List<Alerta> alertas) {
        this.idEquipe = idEquipe;
        this.nomeEquipe = nomeEquipe;
        this.areaAtuacao = areaAtuacao;
        this.contato = contato;
        this.usuarios = usuarios;
        this.alertas = alertas;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }
    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }
    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }
    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }
    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    @Override
    public String toString() {
        return "EquipeResposta{" +
                "idEquipe=" + idEquipe +
                ", nomeEquipe='" + nomeEquipe + '\'' +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }

}
