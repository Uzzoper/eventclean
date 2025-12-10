package dev.juan.EventClean.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventException(DuplicateEventException ex) {

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Please insert a valid identifier for your event and try again.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundEventException(NotFoundEventException ex) {

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Event not found. Please verify your indentifier");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
