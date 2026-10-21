package com.ejemplo.prestamos.Exception;

public class ResourceNoFoundException extends RuntimeException {
    public ResourceNoFoundException(String message) {
        super(message);
    }
}
