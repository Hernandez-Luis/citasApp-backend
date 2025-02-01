package com.citasapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SqlConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite solicitudes desde el frontend en localhost:3000
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Permite solicitudes desde tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todos los headers
                .allowCredentials(true); // Permite enviar cookies y credenciales
    }
}
