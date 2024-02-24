package ru.steeldv.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator managementAppLocator(RouteLocatorBuilder builder) {
		return builder.routes()
//				.route("site", r -> r.path("/site/**").uri("http://localhost:8080/"))
//				.route("notes", r -> r.path("/notes/**").uri("http://localhost:8081/"))
				.build();
	}
}
