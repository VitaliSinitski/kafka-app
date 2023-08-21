package com.example.consumer.service.consumer;

import com.example.consumer.domain.FoodOrder;
import com.example.consumer.domain.dto.FoodOrderDto;
import com.example.consumer.service.FoodOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {
    private static final String orderTopic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final FoodOrderService foodOrderService;

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) {
        try {
            log.info("message consumed {}", message);

            FoodOrderDto foodOrderDto = objectMapper.readValue(message, FoodOrderDto.class);
            FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);

            foodOrderService.persistFoodOrder(foodOrder);
        } catch (JsonProcessingException ex) {
            log.error("Error processing JSON from Kafka message.", ex);
        } catch (Exception ex) {
            log.error("Error processing Kafka message.", ex);
        }
    }
}
