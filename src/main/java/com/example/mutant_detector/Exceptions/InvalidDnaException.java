package com.example.mutant_detector.Exceptions;

//Excepción específica la cual indica que el ADN evaluado, no cumple con los formatos requeridos
public class InvalidDnaException extends RuntimeException {
    public InvalidDnaException(String message) {
        super(message);
    }
}