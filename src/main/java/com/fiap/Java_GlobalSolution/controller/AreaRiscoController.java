package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.model.AreaRisco;
import com.fiap.Java_GlobalSolution.repository.AreaRiscoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/area_risco")
@Validated
public class AreaRiscoController {

    private final AreaRiscoRepository areaRiscoRepository;

    public AreaRiscoController(AreaRiscoRepository areaRiscoRepository) {
        this.areaRiscoRepository = areaRiscoRepository;
    }

    @GetMapping("/lista")
    public String listaAreaRisco(Model model) {
        model.addAttribute("areasRisco", areaRiscoRepository.findAll());
        return "area_risco/lista";
    }

    @GetMapping("/novo")
    public String novaAreaRisco(Model model) {
        AreaRisco areaRisco = new AreaRisco();
        areaRisco.setStatusArea("Ativa");
        model.addAttribute("areaRisco", areaRisco);
        return "area_risco/editar";
    }

    @PostMapping("/salvar")
    public String salvarAreaRisco(@ModelAttribute("areaRisco") AreaRisco areaRisco, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("areaRisco", areaRisco);
            return "area_risco/editar";
        }

        // Se for update, mantenha listas relacionadas (alertas, sensores) se necessário
        if (areaRisco.getIdAreaRisco() != null) {
            Optional<AreaRisco> existente = areaRiscoRepository.findById(areaRisco.getIdAreaRisco());
            if (existente.isPresent()) {
                areaRisco.setAlertas(existente.get().getAlertas());
                areaRisco.setSensores(existente.get().getSensores());
            }
        }
        areaRiscoRepository.save(areaRisco);
        return "redirect:/area_risco/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarAreaRisco(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        AreaRisco areaRisco = areaRiscoRepository.findById(id).orElse(null);
        if (areaRisco == null) {
            redirectAttributes.addFlashAttribute("erro", "Área de risco não encontrada.");
            return "redirect:/area_risco/lista";
        }
        model.addAttribute("areaRisco", areaRisco);
        return "area_risco/editar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAreaRisco(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        AreaRisco areaRisco = areaRiscoRepository.findById(id).orElse(null);

        // Se for necessário, cheque se pode deletar (ex: não ter sensores/alertas)
        if (areaRisco != null && (areaRisco.getSensores() == null || areaRisco.getSensores().isEmpty()) && (areaRisco.getAlertas() == null || areaRisco.getAlertas().isEmpty())) {
            areaRiscoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensagem", "Área de risco deletada com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Área de risco não pode ser deletada pois possui sensores ou alertas associados.");
        }
        return "redirect:/area_risco/lista";
    }

}
