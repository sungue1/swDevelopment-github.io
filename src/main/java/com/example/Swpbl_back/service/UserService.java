package com.example.Swpbl_back.service;

import com.example.Swpbl_back.domain.User;
import com.example.Swpbl_back.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //유저가 입력한값.저장
    public User UserInputSave(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
