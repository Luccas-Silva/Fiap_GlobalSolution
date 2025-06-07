package com.fiap.Java_GlobalSolution.Service;

import com.fiap.Java_GlobalSolution.model.Usuario;
import com.fiap.Java_GlobalSolution.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));
        // cargo deve ser "ADMIN", "DEV"
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getCargo().toUpperCase());
        return new org.springframework.security.core.userdetails.User(
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getAtivo() == 'S',
                true, true, true,
                Collections.singleton(authority)
        );
    }
}
