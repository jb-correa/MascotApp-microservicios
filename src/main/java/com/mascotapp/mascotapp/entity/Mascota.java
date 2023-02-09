package com.mascotapp.mascotapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value="mascota")
public class Mascota {

    @Id
    private String id;
    private String nombre;
    //Crear clases Foto y Usuario para usar como atributos
    private String descripcion;
    private Double peso;
    private Double altura;
    //Cambiar a enum
    private String raza;

}
