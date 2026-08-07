package com.josemurillo.missiontrack.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTransferException.class)
    public ResponseEntity<Map<String, String>> handleInvalidTransfer(
            InvalidTransferException exception) {

        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "error", exception.getMessage()
                ));
    }
}
