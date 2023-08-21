package com.example.consumer.repository;

import com.example.consumer.domain.FoodOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends MongoRepository<FoodOrder, String> {
}
