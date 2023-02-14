package com.mascotapp.mascotapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foto implements Serializable {
    private static final long serialVersionUID = 6522896498689132123L;
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;
    private String uri;
    private String fileName;

    @Temporal (TemporalType.TIMESTAMP)
    private Date alta;

    @Temporal (TemporalType.TIMESTAMP)
    private Date baja;

    private boolean esPerfil;

}