package com.fiap.Java_GlobalSolution.repository;

import com.fiap.Java_GlobalSolution.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
}
