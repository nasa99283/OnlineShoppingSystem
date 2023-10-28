//
//package com.example.demo.Model.Repository;
//import com.example.demo.Model.Entity.Customer;
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class UserRepositoryTest {
//    @Autowired
//    Customer user;
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Test
//    public void testUserCreationAndRetrieval() {
//
//        user.setEmail("test@example.com");
//        user.setPassword("password123");
//        user.setFullname("John Doe");
//
//        customerRepository.save(user);
//
//        assertNotNull(user.getId()); // Assuming the ID is generated upon save
//
//        // Retrieving the user by email
//
//
//    }
//}
//
