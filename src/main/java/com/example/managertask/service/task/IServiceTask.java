package com.example.managertask.service.task;

import com.example.managertask.model.Task;
import com.example.managertask.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface IServiceTask extends GeneralService<Task> {
    @Override
    Page<Task> findAll(Pageable pageable);

    @Override
    Optional findById(Long id);

    @Override
    Task save(Task task);

    @Override
    void remove(Long id);
}
