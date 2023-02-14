package com.mascotapp.mascotapp.repository;

import com.mascotapp.mascotapp.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Perro, String> {

}
