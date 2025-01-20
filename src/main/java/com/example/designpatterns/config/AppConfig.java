package com.example.designpatterns.config;

import com.example.designpatterns.difexample.ClientComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.function.Supplier;

@Configuration
public class AppConfig {

    @Bean
    public Supplier<ClientComponent> clientComponentSupplier() {
        return ClientComponent::new; // Creează o nouă instanță de ClientComponent la fiecare cerere
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
