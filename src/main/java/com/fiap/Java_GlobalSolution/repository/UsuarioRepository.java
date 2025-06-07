package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.equipes IS EMPTY")
    List<Usuario> findUsuariosSemEquipe();;
}
