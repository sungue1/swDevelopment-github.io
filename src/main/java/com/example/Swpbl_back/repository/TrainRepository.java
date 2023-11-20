package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TrainRepository {

    public Train save(Train train) ;


    public Optional<Train> findById(Long id) ;



    public List<Train> findAll();

}
