package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User save(User user) ;


    public Optional<User> findById(Long id);



    public List<User> findAll();


}
