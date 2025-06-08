package com.fiap.Java_GlobalSolution.Service;

import com.fiap.Java_GlobalSolution.model.Usuario;
import com.fiap.Java_GlobalSolution.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioDetailsServiceTest {

    @Test
    void deveRetornarUserDetailsQuandoUsuarioExiste() {
        Usuario usuario = Usuario.builder()
                .email("teste@teste.com")
                .senha("123")
                .cargo("ADMIN")
                .ativo('S')
                .build();

        UsuarioRepository repo = mock(UsuarioRepository.class);
        when(repo.findByEmail("teste@teste.com")).thenReturn(Optional.of(usuario));

        UsuarioDetailsService service = new UsuarioDetailsService();
        service.usuarioRepository = repo;

        UserDetails details = service.loadUserByUsername("teste@teste.com");
        assertEquals("teste@teste.com", details.getUsername());
        assertTrue(details.isEnabled());
        assertTrue(details.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExiste() {
        UsuarioRepository repo = mock(UsuarioRepository.class);
        when(repo.findByEmail("naoexiste@teste.com")).thenReturn(Optional.empty());

        UsuarioDetailsService service = new UsuarioDetailsService();
        service.usuarioRepository = repo;

        assertThrows(UsernameNotFoundException.class,
                () -> service.loadUserByUsername("naoexiste@teste.com"));
    }
}