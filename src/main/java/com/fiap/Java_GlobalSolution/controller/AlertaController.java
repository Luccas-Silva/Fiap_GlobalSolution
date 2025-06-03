package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.model.Alerta;
import com.fiap.Java_GlobalSolution.repository.AlertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/alerta")
@RequiredArgsConstructor
@Validated
public class AlertaController {


}
