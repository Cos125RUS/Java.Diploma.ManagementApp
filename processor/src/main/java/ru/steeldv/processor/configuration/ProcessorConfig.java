package ru.steeldv.processor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.steeldv.library.aspect.LoggingAspect;
import ru.steeldv.library.configuration.Configurator;
import ru.steeldv.library.configuration.GlobalConfig;
import ru.steeldv.library.controller.exception.GlobalExceptionHandler;
import ru.steeldv.library.controller.intercept.LoggingInterceptor;

@Component
public class ProcessorConfig extends GlobalConfig {

}
