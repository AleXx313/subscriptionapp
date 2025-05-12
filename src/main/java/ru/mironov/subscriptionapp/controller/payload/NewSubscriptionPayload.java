package ru.mironov.subscriptionapp.controller.payload;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewSubscriptionPayload {
    @Size(min = 3, max = 50)
    private String title;
    @Size(max = 1000)
    private String details;
}
