package com.mascotapp.mascotapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import com.mascotapp.mascotapp.Enum.Raza;
import com.mascotapp.mascotapp.entity.Foto;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Perro {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;
    private String nombre;
    @ManyToOne
    private Usuario dueño;
    @OneToOne
    private Foto fotoPerfil;
    private List<Foto> fotos;
    private Double peso;
    private Double altura;
    @Enumerated(EnumType.STRING)
    private Raza Raza;
    @Temporal (TemporalType.TIMESTAMP)
    private Date alta;
    @Temporal (TemporalType.TIMESTAMP)
    private Date baja;
    private boolean activo;

}
