package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.Fstvl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class FstvlMemoryRepository implements FstvlRepository {

    private  static Map<Long, Fstvl> store = new HashMap<>(); //가장큰 저장장소 db 처럼 보기 static이 붙지 않은경우 여러개의 저장장소가 생성->문제
    private static Long sequence = 0L;


    @Override
    public Fstvl save(Fstvl fstvl) {
        fstvl.setFstvl_id(++sequence);
        store.put(fstvl.getFstvl_id(),fstvl);
        System.out.println("난 메모리야");
        return fstvl;

    }

    @Override
    public Optional<Fstvl> findById(Long id) {

        return Optional.ofNullable(store.get(id));
    }


    @Override
    public List<Fstvl> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
