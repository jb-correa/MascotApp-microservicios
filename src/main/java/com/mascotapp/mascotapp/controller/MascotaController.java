package com.mascotapp.mascotapp.controller;

import com.mascotapp.mascotapp.entity.Mascota;
import com.mascotapp.mascotapp.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/mascota")
public class MascotaController {

    @Autowired
    public MascotaRepository mascotaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Mascota>getAll(){
        return mascotaRepository.findAll();
    }
    //Metodo alternativo de get all sin anotacion ResponseStatus
    /*
    @GetMapping
    public ResponseEntity <List<Mascota>> getAllMascotas(){
        List<Mascota> mascotas =mascotaRepository.findAll();
        ResponseEntity<List<Mascota>> responseEntity=new ResponseEntity<>(mascotas,HttpStatus.OK )
        return responseEntity;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createMascota(@RequestBody Mascota mascota){
        mascotaRepository.save(mascota);
    }


}
