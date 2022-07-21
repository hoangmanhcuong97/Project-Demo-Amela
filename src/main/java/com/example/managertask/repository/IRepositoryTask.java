package com.example.managertask.repository;

import com.example.managertask.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRepositoryTask extends PagingAndSortingRepository<Task,Long> {
}
