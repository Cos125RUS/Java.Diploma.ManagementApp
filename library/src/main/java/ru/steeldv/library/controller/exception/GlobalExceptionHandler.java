package ru.steeldv.library.controller.exception;

import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
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

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<String> servletException(ServletException e) {
        //TODO: Добавить указание элемента
        return ResponseEntity.status(HttpStatus.CREATED).body("Бесконечная вложенность");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> otherExceptions(Exception e) {
        final String[] body = {"Message: " + e.getMessage() + "\nClass: " + e.getClass() + "\nCause: "
                + e.getCause() + "\nSuppressed: " + Arrays.toString(e.getSuppressed()) + "\n\n"};
        Arrays.asList(e.getStackTrace()).forEach(it -> body[0] += it + "\n");
        return ResponseEntity.badRequest().body(body[0]);
    }
}
