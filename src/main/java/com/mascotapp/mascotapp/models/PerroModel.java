package com.mascotapp.mascotapp.models;

import com.mascotapp.mascotapp.Enum.Raza;
import com.mascotapp.mascotapp.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerroModel implements Serializable {
    private static final long serialVersionUID = 6522896498689132123L;
    private String id;
    private String nombre;
    private String idFotoPerfil;
    private FotoModel fotoPerfil;
    private String idUsuario;
    private UsuarioModel dueño;
    private List<String> idFotos;
    private List<FotoModel>fotos;
    private Integer edad;
    private Double peso;
    private Double alura;
    private Raza raza;
    private Date alta;
    private Date baja;
    private boolean activo;




}
