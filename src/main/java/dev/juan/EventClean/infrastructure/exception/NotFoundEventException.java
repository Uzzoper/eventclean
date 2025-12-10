package dev.juan.EventClean.infrastructure.exception;

public class NotFoundEventException extends RuntimeException{

    public NotFoundEventException(String message) {
        super(message);
    }
}
