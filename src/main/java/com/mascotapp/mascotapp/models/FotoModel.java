package com.mascotapp.mascotapp.models;

import java.io.Serializable;
import java.util.Date;

public class FotoModel implements Serializable {
    private static final long serialVersionUID = 6522896498689132123L;
    private String uri;
    private String fileName;
    private Date alta;
    private Date baja;
    private boolean esPerfil;
}
