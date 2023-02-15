package com.mascotapp.mascotapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 6522896498689132123L;
    private String id;
    private String nombre;
    private String email;
    private String clave;
    private FotoModel fotoDePerfil;
    private String idFotoDePerfil;
    private Date alta;
    private Date baja;
    private List<PerroModel> perros;
    private List<String> perrosId;
    private boolean activo;

}
