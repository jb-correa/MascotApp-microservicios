package com.mascotapp.mascotapp.repository;

import com.mascotapp.mascotapp.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Mascota, String> {

}
