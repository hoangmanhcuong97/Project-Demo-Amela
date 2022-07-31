package com.example.managertask.repository;

import com.example.managertask.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryTask extends JpaRepository<Task,Long> {
    @Query(value = "SELECT t FROM Task t WHERE t.title LIKE %?1% ")
    Page<Task> searchTaskByTitle(String keyWord, Pageable pageable);

    @Query(value = "SELECT t FROM Task t WHERE t.status LIKE ?1")
    Page<Task> searchTaskByStatus(String status, Pageable pageable);
}
