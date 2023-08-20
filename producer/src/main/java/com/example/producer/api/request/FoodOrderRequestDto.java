package com.example.producer.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class FoodOrderRequestDto {
    @NotBlank(message = "Item name is required")
    private String item;

    @Positive(message = "Amount must be a positive value")
    private Double amount;
}
