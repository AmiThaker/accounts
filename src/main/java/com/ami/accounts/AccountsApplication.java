package com.ami.accounts;

import com.ami.accounts.dto.AccountsContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value={AccountsContactInfoDTO.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Micorservices REST API Documentation",
                description = "Bank Accounts micorservices REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name="Ami",
                        email="ami@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Bank Account Microservices REST API Documentation",
                url="http://localhost:8080/swagger-ui/index.html"
        )
)
public class    AccountsApplication {
    public static void main(String [] args){
        SpringApplication.run(AccountsApplication.class,args);
    }

}
