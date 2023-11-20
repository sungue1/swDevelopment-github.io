package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class UserMemoryRepository implements UserRepository{
    private  static Map<Long, User> store = new HashMap<>(); //가장큰 저장장소 db 처럼 보기 static이 붙지 않은경우 여러개의 저장장소가 생성->문제
    private static Long sequence = 0L;


    @Override
    public User save(User user) {
        user.setUser_id(++sequence);
        store.put(user.getUser_id(),user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {

        return Optional.ofNullable(store.get(id));
    }


    @Override
    public List<User> findAll() {
            return new ArrayList<>(store.values());
        }
    public void clearStore() {
        store.clear();
    }
}
