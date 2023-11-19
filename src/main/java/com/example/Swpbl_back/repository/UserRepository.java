package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user) ;


    Optional<User> findById(Long id);



    List<User> findAll();


}
