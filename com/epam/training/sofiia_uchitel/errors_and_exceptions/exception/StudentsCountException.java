package com.epam.training.sofiia_uchitel.errors_and_exceptions.exception;

public class StudentsCountException extends IllegalArgumentException{
    public StudentsCountException(String s) {
        super(s);
    }

    public StudentsCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
