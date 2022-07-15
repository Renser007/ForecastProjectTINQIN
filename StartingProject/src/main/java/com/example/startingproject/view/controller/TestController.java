package com.example.startingproject.view.controller;

import com.example.startingproject.data.entities.UserEntity;
import com.example.startingproject.data.repositories.TestRepository;
import com.example.startingproject.domain.requests.UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @PostMapping("/testUser")
    public void addUser(@RequestBody UserRequest userRequest){
        UserEntity userEntity = new UserEntity(userRequest.getName(), userRequest.getPassword());
        testRepository.save(userEntity);
    }

    @GetMapping("/getUser")
    public List<UserEntity> getAllUsers(){
        return testRepository.findAll();
    }
}
