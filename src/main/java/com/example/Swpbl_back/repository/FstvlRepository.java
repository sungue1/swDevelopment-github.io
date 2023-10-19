package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.Fstvl;

import java.util.Optional;

public interface FstvlRepository {
    Fstvl save(Fstvl fstvl);


    Optional<Fstvl> findById(Long id);
}
