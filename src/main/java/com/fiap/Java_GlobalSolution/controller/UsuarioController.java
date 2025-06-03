package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.model.Usuario;
import com.fiap.Java_GlobalSolution.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
@Validated
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/lista")
    public String listaUsuario(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuario/lista";
    }

    @GetMapping("/novo")
    public String novoUsuario(Model model) {
        Usuario usuario = new Usuario();
        usuario.setCargo("usuario");
        usuario.setAtivo('S');
        model.addAttribute("usuario", usuario);
        return "usuario/editar";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            return "usuario/editar";
        }

        if (usuario.getIdUsuario() == null) {
            usuario.setAtivo('S');
            usuario.setCargo(
                    usuario.getCargo() == null || usuario.getCargo().trim().isEmpty() ? "usuario" : usuario.getCargo()
            );
            usuario.setEquipes(null);
        } else {
            Optional<Usuario> existente = usuarioRepository.findById(usuario.getIdUsuario());
            if (existente.isPresent()) {
                usuario.setEquipes(existente.get().getEquipes());
            }
        }

        usuarioRepository.save(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            redirectAttributes.addFlashAttribute("erro", "Usuário não encontrado.");
            return "redirect:/usuario/lista";
        }
        model.addAttribute("usuario", usuario);
        return "usuario/editar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null && (usuario.getEquipes() == null || usuario.getEquipes().isEmpty())) {
            usuarioRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensagem", "Usuário deletado com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Usuário não pode ser deletado pois participa de uma equipe.");
        }
        return "redirect:/usuario/lista";
    }
}