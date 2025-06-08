package com.fiap.Java_GlobalSolution.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AlertaTest {

    @Test
    void builderAndGettersSetters() {
        Alerta alerta = Alerta.builder()
                .nomeTipoAlerta("Teste")
                .descricaoTipoAlerta("Descricao")
                .nivelGravidadeAlerta(2)
                .dataGeracao(LocalDate.now())
                .mensagem("Mensagem")
                .statusAlerta("Ativo")
                .valorGatilho(10.0)
                .dataInicioAtuacao(LocalDateTime.now())
                .dataFimAtuacao(LocalDateTime.now())
                .observacaoAtuacao("Obs")
                .build();

        alerta.setIdAlerta(10);
        assertEquals(10, alerta.getIdAlerta());
        assertEquals("Teste", alerta.getNomeTipoAlerta());
        assertEquals("Descricao", alerta.getDescricaoTipoAlerta());
        assertEquals(2, alerta.getNivelGravidadeAlerta());
        assertEquals("Mensagem", alerta.getMensagem());
        assertEquals("Ativo", alerta.getStatusAlerta());
        assertEquals(10.0, alerta.getValorGatilho());
        assertEquals("Obs", alerta.getObservacaoAtuacao());
    }
}