package com.example.managertask.repository;

import com.example.managertask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryTask extends JpaRepository<Task,Long> {
}
