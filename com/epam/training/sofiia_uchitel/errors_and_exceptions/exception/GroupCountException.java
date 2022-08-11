package com.epam.training.sofiia_uchitel.errors_and_exceptions.exception;

public class GroupCountException extends IllegalArgumentException{
    public GroupCountException(String s) {
        super(s);
    }

    public GroupCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
