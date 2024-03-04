package ru.steeldv.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator managementAppLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("clients", r -> r.path("/clients/**").uri("http://localhost:8081/"))
				.route("catalog", r -> r.path("/catalog/**").uri("http://localhost:8082/"))
				.route("storage", r -> r.path("/storage/**").uri("http://localhost:8083/"))
				.build();
	}
}
