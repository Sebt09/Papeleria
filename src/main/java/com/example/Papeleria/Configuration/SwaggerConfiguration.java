package com.example.Papeleria.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Papeleria")
                        .version("1.0")
                        .description("Documentacion de la API para gestionar una Papeleria")
                        .contact(new Contact()
                                .name("Soporte API")
                                .email("j.sn43@hotmail.com")));
    }
}
