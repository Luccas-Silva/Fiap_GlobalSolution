package com.fiap.Java_GlobalSolution.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private String senha;
    private char ativo;

    @ManyToMany(mappedBy = "usuarios")
    @JsonIgnore
    private List<EquipeResposta> equipes = new ArrayList<>();

    public Usuario() {
    }
    public Usuario(Integer idUsuario, String nome, String email, String telefone, String cargo, String senha, char ativo, List<EquipeResposta> equipes) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.senha = senha;
        this.ativo = ativo;
        this.equipes = equipes;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getAtivo() {
        return ativo;
    }
    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public List<EquipeResposta> getEquipes() {
        return equipes;
    }
    public void setEquipes(List<EquipeResposta> equipes) {
        this.equipes = equipes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cargo='" + cargo + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                '}';
    }

}
