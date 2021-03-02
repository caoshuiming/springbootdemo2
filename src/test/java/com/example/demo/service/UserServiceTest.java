package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void getUserById() {
        userRepository.getOne(1);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setId(2);
        user.setName("波哥yyds");
        user.setAge(18);
        user.setGender("男");
        userRepository.save(user);
    }

    @Test
    void deleteUser() {
        userRepository.deleteById(1);
    }

    @Test
    void getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(2);
        user.setName("波哥yyds");
        user.setAge(20);
        user.setGender("男");
        userRepository.save(user);
    }
}