package com.mascotapp.mascotapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mascotapp.mascotapp.entity.Mascota;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends MongoRepository<Mascota, String>{

}
