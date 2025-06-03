package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.model.EquipeResposta;
import com.fiap.Java_GlobalSolution.model.Usuario;
import com.fiap.Java_GlobalSolution.repository.EquipeRespostaRepository;
import com.fiap.Java_GlobalSolution.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/equipe")
@Validated
public class EquipeRespostaController {

    private final EquipeRespostaRepository equipeRepo;
    private final UsuarioRepository usuarioRepository;

    public EquipeRespostaController(EquipeRespostaRepository equipeRepo, UsuarioRepository usuarioRepository) {
        this.equipeRepo = equipeRepo;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/lista")
    public String listarEquipes(Model model) {
        List<EquipeResposta> equipes = equipeRepo.findAll();
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("equipes", equipes);
        model.addAttribute("usuariosDisponiveis", usuarios);
        return "equipe/lista";
    }

    @PostMapping("/{idEquipe}/adicionar-integrante")
    public String adicionarIntegrante(
            @PathVariable Integer idEquipe,
            @RequestParam Integer idUsuario,
            @RequestParam String cargo,
            RedirectAttributes redirectAttributes
    ) {
        EquipeResposta equipe = equipeRepo.findById(idEquipe).orElseThrow();
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        usuario.setCargo(cargo);
        equipe.getUsuarios().add(usuario);
        equipeRepo.save(equipe);
        redirectAttributes.addFlashAttribute("mensagem", "Integrante adicionado com sucesso!");
        return "redirect:/equipe/lista";
    }

    @GetMapping("/{idEquipe}/remover-integrante/{idUsuario}")
    public String removerIntegrante(@PathVariable Integer idEquipe, @PathVariable Integer idUsuario, RedirectAttributes redirectAttributes) {
        EquipeResposta equipe = equipeRepo.findById(idEquipe).orElseThrow();
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        equipe.getUsuarios().remove(usuario);
        equipeRepo.save(equipe);
        redirectAttributes.addFlashAttribute("mensagem", "Integrante removido com sucesso!");
        return "redirect:/equipe/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("equipe", new EquipeResposta());
        return "equipe/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute EquipeResposta equipe) {
        equipeRepo.save(equipe);
        return "redirect:/equipe/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        EquipeResposta equipe = equipeRepo.findById(id).orElseThrow();
        model.addAttribute("equipe", equipe);
        return "equipe/form";
    }
}