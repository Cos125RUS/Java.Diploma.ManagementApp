package ru.steeldv.processor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.steeldv.processor.aspect.LoggingAspect;
import ru.steeldv.processor.controller.intercept.LoggingInterceptor;

/**
 * Бины клиентского сервиса
 */
@Configuration
public class ProcessorConfig implements WebMvcConfigurer {

    /**
     * Аспекты логирования
     * @return
     */
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
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
