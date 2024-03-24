package ru.steeldv.clients.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.steeldv.clients.aspect.LoggingAspect;

@Configuration
public class AspectConfig {
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
