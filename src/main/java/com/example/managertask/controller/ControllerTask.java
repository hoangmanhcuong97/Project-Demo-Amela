package com.example.managertask.controller;
import com.example.managertask.model.Task;
import com.example.managertask.service.task.IServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("")
@EnableSpringDataWebSupport
public class ControllerTask {

    @Autowired
    private IServiceTask iServiceTask;

    @GetMapping("/list-task")
    public ModelAndView showListTask(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/ManagerTask/task");
        Page<Task> taskList = iServiceTask.findAll(pageable);

        modelAndView.addObject("taskList", taskList);
        return modelAndView;
    }

    @GetMapping("/create-task")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/ManagerTask/createTask");
        modelAndView.addObject("createTask", new Task());
        return modelAndView;
    }
    @PostMapping("/create-task")
    public ModelAndView saveTask(@ModelAttribute("task") Task task) {
        iServiceTask.save(task);
        ModelAndView modelAndView = new ModelAndView("/ManagerTask/createTask");
        modelAndView.addObject("createTask", new Task());
        modelAndView.addObject("message", "New task created successfully");
        return modelAndView;
    }
    @GetMapping("/detail-task/{id}")
    public ModelAndView showDetailTask(@PathVariable("id") Long id){
        Optional<Task> task = iServiceTask.findById(id);
        ModelAndView mav = new ModelAndView("/ManagerTask/detailTask");
        mav.addObject("detailTask", task.get());
        return mav;
    }
    @GetMapping("/edit-task/{id}")
    public ModelAndView showEditTask (@PathVariable Long id){
        Optional<Task> task = iServiceTask.findById(id);
        if (task.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/ManagerTask/editTask");
            modelAndView.addObject("editTask", task.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-task")
    public ModelAndView updateTask(@ModelAttribute("task") Task task) {
        iServiceTask.save(task);
        ModelAndView modelAndView = new ModelAndView("/ManagerTask/editTask");
        modelAndView.addObject("editTask", task);
        return modelAndView;
    }

    @GetMapping ("/delete-task/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        iServiceTask.remove(id);
        return "redirect:/list-task";
    }

}