package com.gestion.inventario.advice;

import com.gestion.inventario.exception.RecursoNotFoundException;
import com.gestion.inventario.models.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorGlobalDeErrores {

    @ExceptionHandler(RecursoNotFoundException.class)
    public ResponseEntity<ErrorResponse> manejarUsuarioNoEncontrado(RecursoNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
