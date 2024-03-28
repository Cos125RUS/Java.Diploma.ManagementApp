package ru.steeldv.library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.steeldv.library.aspect.LoggingAspect;
import ru.steeldv.library.controller.exception.GlobalExceptionHandler;
import ru.steeldv.library.controller.intercept.LoggingInterceptor;

/**
 * Бины клиентского сервиса
 */

@Configuration
public class GlobalConfig  {

    /**
     * Аспекты логирования
     * @return
     */
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }

    /**
     * Глобальный перехватчик ошибок
     * @return
     */
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }


}
