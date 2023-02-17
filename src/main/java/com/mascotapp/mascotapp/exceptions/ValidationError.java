package com.mascotapp.mascotapp.exceptions;

public class ValidationError extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidationError(String msg) {
        super(msg);
    }
}