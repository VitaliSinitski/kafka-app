package com.example.producer.service;

import com.example.producer.api.request.FoodOrderRequestDto;
import com.example.producer.domain.FoodOrder;
import com.example.producer.service.producer.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderService {
    private final Producer producer;

    public String createFoodOrder(FoodOrderRequestDto foodOrderRequest) throws JsonProcessingException {
        FoodOrder foodOrder = convertToFoodOrder(foodOrderRequest);
        return producer.sendMessage(foodOrder);
    }

    private FoodOrder convertToFoodOrder(FoodOrderRequestDto foodOrderRequest) {
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setItem(foodOrderRequest.getItem());
        foodOrder.setAmount(foodOrderRequest.getAmount());
        return foodOrder;
    }
}
