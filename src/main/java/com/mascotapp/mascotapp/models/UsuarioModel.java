package com.mascotapp.mascotapp.models;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 6522896498689132123L;

    private String nombre;
    private String email;
    private String clave;
    private Date alta;
    private Date baja;
    //private List<PerroModel> perros;
    //private List<String> perrosId;
    private boolean activo;

}
