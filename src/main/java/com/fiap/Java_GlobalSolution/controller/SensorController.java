package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.model.Alerta;
import com.fiap.Java_GlobalSolution.model.AreaRisco;
import com.fiap.Java_GlobalSolution.model.Sensor;
import com.fiap.Java_GlobalSolution.repository.AlertaRepository;
import com.fiap.Java_GlobalSolution.repository.AreaRiscoRepository;
import com.fiap.Java_GlobalSolution.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/sensor")
@Validated
public class SensorController {

    private final SensorRepository sensorRepository;
    private final AreaRiscoRepository areaRiscoRepository;
    private final AlertaRepository alertaRepository;

    public SensorController(SensorRepository sensorRepository, AreaRiscoRepository areaRiscoRepository, AlertaRepository alertaRepository) {
        this.sensorRepository = sensorRepository;
        this.areaRiscoRepository = areaRiscoRepository;
        this.alertaRepository = alertaRepository;
    }

    @GetMapping("/lista")
    public String listaSensor(Model model) {
        List<Sensor> sensores = sensorRepository.findAll();
        Map<Integer, List<Alerta>> alertasPorSensor = new HashMap<>();

        for (Sensor sensor : sensores) {
            List<Alerta> alertas = alertaRepository.findBySensor_IdSensor(sensor.getIdSensor());
            alertasPorSensor.put(sensor.getIdSensor(), alertas);
        }

        model.addAttribute("sensores", sensores);
        model.addAttribute("alertasPorSensor", alertasPorSensor);
        return "sensor/lista";
    }

    @GetMapping("/novo")
    public String novoSensor(Model model) {
        model.addAttribute("sensor", new Sensor());
        model.addAttribute("areasRisco", areaRiscoRepository.findAll());
        return "sensor/editar";
    }

    @PostMapping("/salvar")
    public String salvarSensor(@ModelAttribute("sensor") Sensor sensor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("areasRisco", areaRiscoRepository.findAll());
            return "sensor/editar";
        }
        if (sensor.getAreaRisco() != null && sensor.getAreaRisco().getIdAreaRisco() != null) {
            Optional<AreaRisco> areaOptional = areaRiscoRepository.findById(sensor.getAreaRisco().getIdAreaRisco());
            areaOptional.ifPresent(sensor::setAreaRisco);
        }
        sensorRepository.save(sensor);
        return "redirect:/sensor/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarSensor(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Sensor> sensorOpt = sensorRepository.findById(id);
        if (sensorOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("erro", "Sensor não encontrado.");
            return "redirect:/sensor/lista";
        }
        model.addAttribute("sensor", sensorOpt.get());
        model.addAttribute("areasRisco", areaRiscoRepository.findAll());
        return "sensor/editar";
    }

    @GetMapping("/remover/{id}")
    public String removerSensor(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (sensorRepository.existsById(id)) {
            sensorRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensagem", "Sensor deletado com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Sensor não encontrado.");
        }
        return "redirect:/sensor/lista";
    }

}
