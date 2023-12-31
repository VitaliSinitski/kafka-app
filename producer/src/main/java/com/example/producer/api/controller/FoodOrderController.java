package com.example.producer.api.controller;

import com.example.producer.api.request.FoodOrderRequestDto;
import com.example.producer.domain.FoodOrder;
import com.example.producer.service.FoodOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Validated
public class FoodOrderController {
    private final FoodOrderService foodOrderService;

    @PostMapping
    public ResponseEntity<String> createFoodOrder(@RequestBody @Valid FoodOrderRequestDto foodOrderRequest) throws JsonProcessingException {
        String result = foodOrderService.createFoodOrder(foodOrderRequest);
        return ResponseEntity.ok(result);
    }
}
