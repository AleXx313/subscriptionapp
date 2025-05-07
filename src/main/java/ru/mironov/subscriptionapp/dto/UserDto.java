package ru.mironov.subscriptionapp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UserDto (
        @Size(min = 3, max = 50) String username,

        @Email String email,

        @Past LocalDateTime birthdate
){}
