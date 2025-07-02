package br.com.estudos.dankicode.pizzariadankicode.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorException {

    @ExceptionHandler(PizzaNaoEncontradaException.class)
    public ResponseEntity tratarPizzaNaoEncontradaException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity tratarForbiddenException() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarEntityNotFoundException() {
        return ResponseEntity.notFound().build();
    }

}
