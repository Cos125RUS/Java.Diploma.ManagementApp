package ru.steeldv.documents.configuration;

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
public class DocumentsConfig implements WebMvcConfigurer {

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

    /**
     * Перехватчик событий
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
    }

}
