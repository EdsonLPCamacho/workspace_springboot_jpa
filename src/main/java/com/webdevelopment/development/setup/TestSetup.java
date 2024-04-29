package com.webdevelopment.development.setup;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webdevelopment.development.entity.OrderItem;
import com.webdevelopment.development.entity.User;
import com.webdevelopment.development.entity.enums.OrderItemStatus;
import com.webdevelopment.development.repositories.OrderItemRepository;
import com.webdevelopment.development.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestSetup implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User usr1 = new User(null, "Paul", "paul@paul.com", "999999999");
        User usr2 = new User(null, "Angela", "angela@angela.com", "9988889999");

        //ISO 8601 UTC Time
        OrderItem item01 = new OrderItem(null, Instant.parse("2024-04-24T11:37:00Z"), OrderItemStatus.WAITING_PAYMENT, usr1);
        OrderItem item02 = new OrderItem(null, Instant.parse("2024-04-24T11:37:00Z"), OrderItemStatus.DELIVERED, usr2);

        userRepository.saveAll(Arrays.asList(usr1, usr2));
        orderItemRepository.saveAll(Arrays.asList(item01, item02));
    }
}
