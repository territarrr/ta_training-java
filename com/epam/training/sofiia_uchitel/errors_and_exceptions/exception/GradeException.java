package com.epam.training.sofiia_uchitel.errors_and_exceptions.exception;

public class GradeException extends IllegalArgumentException{
    public GradeException(String s) {
        super(s);
    }

    public GradeException(String message, Throwable cause) {
        super(message, cause);
    }
}
