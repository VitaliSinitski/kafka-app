package com.example.producer.domain;

import lombok.Data;
import lombok.Value;

@Data
public class FoodOrder {
    private String item;
    private Double amount;
}
