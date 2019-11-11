package com.curiel.catalogos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <h1>Configuración global de CORS</h1>
 * clase para manejar la configuracion de cors
 * @author Eleazar Curiel Monjaraz
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	  /**
     * Todos los orígenes y métodos GET, HEAD y POST están permitidos
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
        .allowCredentials(true);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
