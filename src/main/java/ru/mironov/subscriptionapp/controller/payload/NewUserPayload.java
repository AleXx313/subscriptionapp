package ru.mironov.subscriptionapp.controller.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserPayload {

    @Size(min = 3, max = 50)
    private String username;

    @Email
    private String email;

    @Past
    private LocalDateTime birthdate;
}
