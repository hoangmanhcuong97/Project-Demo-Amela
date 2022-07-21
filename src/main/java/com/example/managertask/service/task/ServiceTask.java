package com.example.managertask.service.task;

import com.example.managertask.model.Task;
import com.example.managertask.repository.IRepositoryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ServiceTask implements IServiceTask{
    @Autowired
    private IRepositoryTask iRepositoryTask;

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return iRepositoryTask.findAll(pageable);
    }

    @Override
    public Optional findById(Long id) {
        return iRepositoryTask.findById(id);
    }

    @Override
    public Task save(Task task) {
        return iRepositoryTask.save(task);
    }

    @Override
    public void remove(Long id) {
        iRepositoryTask.deleteById(id);
    }
}
