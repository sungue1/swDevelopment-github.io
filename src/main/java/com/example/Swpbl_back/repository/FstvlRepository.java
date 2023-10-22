package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.Fstvl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface FstvlRepository {

    public Fstvl save(Fstvl fstvl);


    public Optional<Fstvl> findById(Long id);


    public List<Fstvl> findAll();
}
