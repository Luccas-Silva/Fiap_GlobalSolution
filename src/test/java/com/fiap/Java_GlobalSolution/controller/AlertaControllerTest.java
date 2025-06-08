package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.model.Alerta;
import com.fiap.Java_GlobalSolution.repository.AlertaRepository;
import com.fiap.Java_GlobalSolution.repository.AreaRiscoRepository;
import com.fiap.Java_GlobalSolution.repository.EquipeRespostaRepository;
import com.fiap.Java_GlobalSolution.repository.SensorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.ui.Model;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlertaControllerTest {

    @Mock
    private AlertaRepository alertaRepository;
    @Mock
    private AreaRiscoRepository areaRiscoRepository;
    @Mock
    private EquipeRespostaRepository equipeRespostaRepository;
    @Mock
    private SensorRepository sensorRepository;
    @Mock
    private Model model;

    @InjectMocks
    private AlertaController alertaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listaAlerta_deveAdicionarAlertasNoModelERetornarView() {
        when(alertaRepository.findAll()).thenReturn(Collections.emptyList());
        String view = alertaController.listaAlerta(model);
        verify(model).addAttribute(eq("alertas"), any());
        assertEquals("alerta/lista", view);
    }
}