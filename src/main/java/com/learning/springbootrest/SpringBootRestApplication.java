package com.learning.springbootrest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "CRUD simple api",
                description = "This is simple CRUD project",
                version = "v1.0",
                contact = @Contact(
                        name = "Udit Sharma",
                        email = "uditsharma1632@gmail.com",
                        url = "https://github.com/UditSharma1632"
                )
        )
)
public class SpringBootRestApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }

}
