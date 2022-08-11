package com.epam.training.sofiia_uchitel.errors_and_exceptions.exception;

public class FacultetsCountException extends IllegalArgumentException{
    public FacultetsCountException(String s) {
        super(s);
    }

    public FacultetsCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
