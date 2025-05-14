package ru.mironov.subscriptionapp.controller.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Модель для обновления пользователя")
public class UpdateUserPayload {

    @Size(min = 3, max = 50)
    @Schema(description = "Имя пользователя", example = "Иван Иванов")
    private String username;

    @Email
    @Schema(description = "Email пользователя", example = "ivan@ivanov.ru")
    private String email;

    @Past
    @Schema(description = "Дата рождения пользователя", example = "2025-05-14")
    private LocalDate birthdate;
}