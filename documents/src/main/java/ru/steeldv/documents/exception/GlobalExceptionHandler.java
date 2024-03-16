package ru.steeldv.documents.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;


//TODO: Сделать библиотечным классом и импортировать во все сервисы-репозитории


@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementException(NoSuchElementException e) {
        //TODO: Добавить указание элемента
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Элемент не найден");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> otherExceptions(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
