package com.mascotapp.mascotapp.repository;


import com.mascotapp.mascotapp.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerroRepository extends JpaRepository<Perro, String> {

}
