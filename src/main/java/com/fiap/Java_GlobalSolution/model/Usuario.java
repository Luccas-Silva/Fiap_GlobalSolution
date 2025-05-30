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
    private List<EquipeResposta> equipes;

}
