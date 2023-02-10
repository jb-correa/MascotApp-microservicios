package com.mascotapp.mascotapp.repository;


import com.mascotapp.mascotapp.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, String> {

}
