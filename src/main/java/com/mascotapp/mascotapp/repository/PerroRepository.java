package com.mascotapp.mascotapp.repository;


import com.mascotapp.mascotapp.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import java.util.List;


@Repository
public interface PerroRepository extends JpaRepository<Perro, String> {
    @Query("SELECT a from Perro a WHERE a.activo = true ORDER BY a.nombre")
    public List<Perro> searchAssets();

    @Query("SELECT a from Perro a WHERE a.activo = true ORDER BY a.nombre")
    public Page<Perro> searchAssets(Pageable pageable);

    @Query("SELECT a from Perro a WHERE a.activo = true AND a.nombre LIKE :q OR a.apodo LIKE :q OR a.raza LIKE :q ORDER BY a.nombre DESC")
    public Page<Perro> searchByParam(Pageable pageable, @Param("q") String q);

    @Query("SELECT a from Perro a WHERE a.activo = true AND a.nombre LIKE :q OR a.apodo LIKE :q OR a.raza LIKE :q ORDER BY a.nombre DESC")
    public List<Perro> searchByParam(@Param("q") String q);

}
