package com.project.shopapp.components;

import com.project.shopapp.models.Category;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@KafkaListener(id = "groupA", topics = { "get-all-categories", "insert-a-category" })
public class MyKafkaListener {
    @KafkaHandler
    public void listenCategory(Category category) {
        System.out.println("Received: " + category);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Received unknown: " + object);
    }
    @KafkaHandler
    public void listenListOfCategories(List<Category> categories) {
        System.out.println("Received: " + categories);
    }

}
