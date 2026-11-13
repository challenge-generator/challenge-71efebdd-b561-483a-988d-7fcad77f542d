package com.banco.prestamos.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Cálculo de Intereses - Préstamos Bancarios")
                .version("1.0.0")
                .description("""
                    Esta API permite calcular intereses simples y compuestos 
                    para préstamos bancarios. Proporciona endpoints para el 
                    cálculo de intereses por período y el interés total acumulado.
                    """)
                .contact(new Contact()
                    .name("Equipo de Desarrollo - Banco")
                    .email("desarrollo@banco.com")
                    .url("https://www.banco.com"))
                .license(new License()
                    .name("Licencia Proprietaria")
                    .url("https://www.banco.com/licencia")))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .description("Autenticación mediante token JWT")));
    }
}