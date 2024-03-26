package ru.steeldv.processor.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.steeldv.processor.aspect.annotation.ErrorLog;

import java.util.NoSuchElementException;


//TODO: Сделать библиотечным классом и импортировать во все сервисы-репозитории


@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ErrorLog
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementException(NoSuchElementException e) {
        //TODO: Добавить указание элемента
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Элемент не найден");
    }

    @ErrorLog
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> otherExceptions(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
