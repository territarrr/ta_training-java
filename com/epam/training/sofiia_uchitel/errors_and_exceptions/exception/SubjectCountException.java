package com.epam.training.sofiia_uchitel.errors_and_exceptions.exception;

public class SubjectCountException extends IllegalArgumentException {
    public SubjectCountException(String s) {
        super(s);
    }

    public SubjectCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
