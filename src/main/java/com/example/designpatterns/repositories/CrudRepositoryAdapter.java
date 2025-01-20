package com.example.designpatterns.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class CrudRepositoryAdapter<T, ID> implements CrudRepository<T, ID> {

    private final JpaRepository<T, ID> jpaRepository;

    public CrudRepositoryAdapter(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }
}

