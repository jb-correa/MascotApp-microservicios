package com.mascotapp.mascotapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import com.mascotapp.mascotapp.Enum.Raza;
import com.mascotapp.mascotapp.entity.Foto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Perro implements Serializable {
    private static final long serialVersionUID = 6522896498689132123L;
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    @ManyToOne
    private Usuario dueño;
    @OneToOne
    private Foto fotoPerfil;
    private List<Foto> fotos;
    private Integer edad;
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
