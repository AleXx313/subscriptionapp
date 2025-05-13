package ru.mironov.subscriptionapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "SubscriptionApp Documentation",
                version = "1.0.0",
                description = "API для управления пользователями и подписками",
                contact = @Contact(
                        name = "Alexey Mironov",
                        email = "alexeymironov1991@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
