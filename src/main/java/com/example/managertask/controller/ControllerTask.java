package com.example.managertask.controller;
import com.example.managertask.model.Task;
import com.example.managertask.service.task.IServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
@EnableSpringDataWebSupport
public class ControllerTask {

    @Autowired
    private IServiceTask iServiceTask;

    @GetMapping("/list-task")
    public ModelAndView showListTask(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("ManagerTask/Task");
        Page<Task> taskList = iServiceTask.findAll(pageable);
        modelAndView.addObject("taskList", taskList);
        return modelAndView;
    }
}