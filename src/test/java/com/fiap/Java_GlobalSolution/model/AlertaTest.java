package com.fiap.Java_GlobalSolution.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AlertaTest {

    @Test
    void gettersSetters() {
        Alerta alerta = new Alerta();
        alerta.setIdAlerta(10);
        alerta.setNomeTipoAlerta("Teste");
        alerta.setDescricaoTipoAlerta("Descricao");
        alerta.setNivelGravidadeAlerta(2);
        alerta.setDataGeracao(LocalDate.now());
        alerta.setMensagem("Mensagem");
        alerta.setStatusAlerta("Ativo");
        alerta.setValorGatilho(10.0);
        alerta.setDataInicioAtuacao(LocalDateTime.now());
        alerta.setDataFimAtuacao(LocalDateTime.now());
        alerta.setObservacaoAtuacao("Obs");

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