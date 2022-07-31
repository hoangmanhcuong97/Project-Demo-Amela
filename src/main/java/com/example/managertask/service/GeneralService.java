package com.example.managertask.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GeneralService<T> {
    Page<T> findAll(Pageable pageable);

    Page<T> findTaskByTitle(String keyWord, Pageable pageable);

    Page<T> findTaskByStatus(String status, Pageable pageable);

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
