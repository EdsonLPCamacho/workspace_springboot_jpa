package com.webdevelopment.development.setup;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webdevelopment.development.entity.Category;
import com.webdevelopment.development.entity.OrderItem;
import com.webdevelopment.development.entity.Products;
import com.webdevelopment.development.entity.User;
import com.webdevelopment.development.entity.enums.OrderItemStatus;
import com.webdevelopment.development.repositories.CategoryRepository;
import com.webdevelopment.development.repositories.OrderItemRepository;
import com.webdevelopment.development.repositories.ProductsRepository;
import com.webdevelopment.development.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestSetup implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductsRepository productsRepository;
    
    @Override
    public void run(String... args) throws Exception {
    	
    	//Creating categories
    	Category cat01 = new Category(null, "Computers");
    	Category cat02 = new Category(null, "TVs");
    	
    	Products pd01 = new Products(null, "The Prince of Egypt", "Lorem ipsum dolor", 67.5, "");
    	Products pd02 = new Products(null, "The Lion King", "Lorem ipsum dolor", 75.0, "");
    	Products pd03 = new Products(null, "Aladdin", "Lorem ipsum dolor", 60.0, "");
    	Products pd04 = new Products(null, "Beauty and the Beast", "Lorem ipsum dolor", 55.0, "");
    	Products pd05 = new Products(null, "Computer i9", "Lorem ipsum dolor", 3770.0, "");
    	
    	//Save to database
    	categoryRepository.saveAll(Arrays.asList(cat01, cat02));
    	productsRepository.saveAll(Arrays.asList(pd01, pd02, pd03, pd04, pd05));
    	
    	//Association between objects
    	pd01.getCategories().add(cat02);
    	pd02.getCategories().add(cat02);
    	pd03.getCategories().add(cat02);
    	pd04.getCategories().add(cat02);
    	pd05.getCategories().add(cat01);
    	
    	//Save in memory
    	productsRepository.saveAll(Arrays.asList(pd01, pd02, pd03, pd04, pd05));
    	
    	
    	//Save to database
    	categoryRepository.saveAll(Arrays.asList(cat01,cat02));

        User usr1 = new User(null, "Paul", "paul@paul.com", "999999999");
        User usr2 = new User(null, "Angela", "angela@angela.com", "9988889999");

        //ISO 8601 UTC Time
        OrderItem item01 = new OrderItem(null, Instant.parse("2024-04-24T11:37:00Z"), OrderItemStatus.WAITING_PAYMENT, usr1);
        OrderItem item02 = new OrderItem(null, Instant.parse("2024-04-24T11:37:00Z"), OrderItemStatus.DELIVERED, usr2);

        userRepository.saveAll(Arrays.asList(usr1, usr2));
        orderItemRepository.saveAll(Arrays.asList(item01, item02));
    }
}
