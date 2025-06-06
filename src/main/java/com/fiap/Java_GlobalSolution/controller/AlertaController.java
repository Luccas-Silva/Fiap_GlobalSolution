package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.model.Alerta;
import com.fiap.Java_GlobalSolution.repository.AlertaRepository;
import com.fiap.Java_GlobalSolution.repository.AreaRiscoRepository;
import com.fiap.Java_GlobalSolution.repository.EquipeRespostaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/alerta")
@Validated
public class AlertaController {

    private final AlertaRepository alertaRepository;
    private final AreaRiscoRepository areaRiscoRepository;
    private final EquipeRespostaRepository equipeRespostaRepository;

    public AlertaController(AlertaRepository alertaRepository, AreaRiscoRepository areaRiscoRepository, EquipeRespostaRepository equipeRespostaRepository) {
        this.alertaRepository = alertaRepository;
        this.areaRiscoRepository = areaRiscoRepository;
        this.equipeRespostaRepository = equipeRespostaRepository;
    }

    @GetMapping("/lista")
    public String listaAlerta(Model model) {
        model.addAttribute("alertas", alertaRepository.findAll());
        return "alerta/lista";
    }

    @GetMapping("/novo")
    public String novoAlerta(Model model) {
        model.addAttribute("alerta", new Alerta());
        model.addAttribute("areasRisco", areaRiscoRepository.findAll());
        model.addAttribute("equipesResposta", equipeRespostaRepository.findAll());
        return "alerta/editar";
    }

    @PostMapping("/salvar")
    public String salvarAlerta(@ModelAttribute("alerta") Alerta alerta, BindingResult result, Model model) {
        model.addAttribute("areasRisco", areaRiscoRepository.findAll());
        model.addAttribute("equipesResposta", equipeRespostaRepository.findAll());

        if (result.hasErrors()) {
            return "alerta/editar";
        }

        // Atualiza AreaRisco e EquipeResposta pelo id
        if (alerta.getAreaRisco() != null && alerta.getAreaRisco().getIdAreaRisco() != null) {
            areaRiscoRepository.findById(alerta.getAreaRisco().getIdAreaRisco())
                    .ifPresent(alerta::setAreaRisco);
        } else {
            alerta.setAreaRisco(null);
        }
        if (alerta.getEquipeResposta() != null && alerta.getEquipeResposta().getIdEquipe() != null) {
            equipeRespostaRepository.findById(alerta.getEquipeResposta().getIdEquipe())
                    .ifPresent(alerta::setEquipeResposta);
        } else {
            alerta.setEquipeResposta(null);
        }

        alertaRepository.save(alerta);
        return "redirect:/alerta/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarAlerta(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Alerta> alertaOpt = alertaRepository.findById(id);
        if (alertaOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("erro", "Alerta não encontrado.");
            return "redirect:/alerta/lista";
        }
        model.addAttribute("alerta", alertaOpt.get());
        model.addAttribute("areasRisco", areaRiscoRepository.findAll());
        model.addAttribute("equipesResposta", equipeRespostaRepository.findAll());
        return "alerta/editar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAlerta(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (alertaRepository.existsById(id)) {
            alertaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensagem", "Alerta deletado com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Alerta não encontrado.");
        }
        return "redirect:/alerta/lista";
    }


}
