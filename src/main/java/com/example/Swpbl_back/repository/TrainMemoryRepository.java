package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.domain.Train;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class TrainMemoryRepository implements TrainRepository{
    private  static Map<Long, Train> store = new HashMap<>(); //가장큰 저장장소 db 처럼 보기 static이 붙지 않은경우 여러개의 저장장소가 생성->문제
    private static Long sequence = 0L;


    @Override
    public Train save(Train train) {
        train.setTrain_id(++sequence);
        store.put(train.getTrain_id(),train);
        return train;
    }

    @Override
    public Optional<Train> findById(Long id) {

        return Optional.ofNullable(store.get(id));
    }


    @Override
    public List<Train> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
