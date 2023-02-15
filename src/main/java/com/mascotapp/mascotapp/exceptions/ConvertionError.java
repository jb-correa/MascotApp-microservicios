package com.mascotapp.mascotapp.exceptions;

public class ConvertionError extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConvertionError(String msg) {
        super(msg);
    }
}