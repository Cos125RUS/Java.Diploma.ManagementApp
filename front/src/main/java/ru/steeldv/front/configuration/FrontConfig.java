package ru.steeldv.front.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.steeldv.library.aspect.LoggingAspect;
import ru.steeldv.library.configuration.GlobalConfig;
import ru.steeldv.library.controller.exception.GlobalExceptionHandler;
import ru.steeldv.library.controller.intercept.LoggingInterceptor;

/**
 * Бины клиентского сервиса
 */
@Component
public class FrontConfig extends GlobalConfig {

}
