package com.mascotapp.mascotapp.controller;

import com.mascotapp.mascotapp.entity.Perro;
import com.mascotapp.mascotapp.repository.PerroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/mascota")
public class PerroController {

    @Autowired
    public PerroRepository perroRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Perro>getAll(){
        return perroRepository.findAll();
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
    public void createMascota(@RequestBody Perro perro){
        perroRepository.save(perro);
    }


}
