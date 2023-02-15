package com.mascotapp.mascotapp.repository;

import com.mascotapp.mascotapp.entity.Perro;
import com.mascotapp.mascotapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("SELECT a from Usuario a WHERE a.activo = true ORDER BY a.nombre")
    public List<Usuario> searchAssets();

    @Query("SELECT a from Usuario a WHERE a.activo = true ORDER BY a.nombre")
    public Page<Usuario> searchAssets(Pageable pageable);

    @Query("SELECT a from Usuario a WHERE a.activo = true AND a.nombre LIKE :q OR a.apellido LIKE :q OR a.dni LIKE :q OR a.rol LIKE :q ORDER BY a.apellido DESC")
    public Page<Usuario> searchByParam(Pageable pageable, @Param("q") String q);

    @Query("SELECT a from Usuario a WHERE a.activo = true AND a.nombre LIKE :q OR a.apellido LIKE :q OR a.dni LIKE :q OR a.rol LIKE :q ORDER BY a.apellido DESC")
    public List<Usuario> searchByParam(@Param("q") String q);

}
