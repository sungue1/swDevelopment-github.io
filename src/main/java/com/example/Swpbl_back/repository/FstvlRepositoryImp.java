package com.example.Swpbl_back.repository;

import com.example.Swpbl_back.domain.Fstvl;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class FstvlRepositoryImp implements FstvlRepository {
    private  EntityManager em; // jpa 의존성을 추가하면 spring boot 가 자동으로 생성해줌.

    public FstvlRepositoryImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public Fstvl save(Fstvl fstvl) {
        em.persist(fstvl);
        return fstvl;
    }

    @Override
    public Optional<Fstvl> findById(Long id) {
        Fstvl fstvl = em.find(Fstvl.class, id);
        return Optional.ofNullable(fstvl);
    }

}
