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
public class EquipeResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;

    private String nomeEquipe;
    private String areaAtuacao;
    private String contato;

    @ManyToMany
    @JoinTable(
            name = "equipe_resposta_usuario",
            joinColumns = @JoinColumn(name = "idEquipe"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario")
    )
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "equipeResposta")
    private List<Alerta> alertas;

}
