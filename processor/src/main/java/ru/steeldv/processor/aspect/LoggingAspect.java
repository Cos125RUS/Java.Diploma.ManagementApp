package ru.steeldv.processor.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Постоперационное логирование по аннотации
 */
@Aspect
@Log
public class LoggingAspect {

    /**
     * Логирование вызовов методов
     * @param joinPoint
     * @throws Throwable
     */
    @AfterReturning(value = "@annotation(ru.steeldv.processor.aspect.annotation.CallingLog)")
    public void callingLog(JoinPoint joinPoint) throws Throwable {
        StringBuilder args = new StringBuilder();
        String name = joinPoint.getSignature().getName();
        Arrays.stream(joinPoint.getArgs()).forEach(args::append);
        log.info("Имя метода: " + name);
        log.info("Аргументы: " + args);
    }

    /**
     * Логирование ошибок
     * @param joinPoint
     * @throws Throwable
     */
    @AfterReturning(value = "@annotation(ru.steeldv.processor.aspect.annotation.ErrorLog)")
    public void errorLog(JoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        String message = ((Exception) joinPoint.getArgs()[0]).getMessage();
        log.info("Ошибка! (" + name + ") : " + message);
    }
}
