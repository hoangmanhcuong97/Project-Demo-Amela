package com.example.managertask.service.task;

import com.example.managertask.model.Task;
import com.example.managertask.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;
public interface IServiceTask extends GeneralService<Task> {
    @Override
    Page<Task> findAll(Pageable pageable);

    @Override
    Page<Task> findTaskByTitle(String keyWord, Pageable pageable);

    @Override
    Page<Task> findTaskByStatus(String status, Pageable pageable);

    @Override
    Optional<Task> findById(Long id);

    @Override
    void save(Task task);

    @Override
    void remove(Long id);
}
