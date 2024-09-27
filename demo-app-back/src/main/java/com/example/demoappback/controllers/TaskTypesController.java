package com.example.demoappback.controllers;

import com.example.demoappback.services.taskTypes.TaskTypeDto;
import com.example.demoappback.services.taskTypes.TaskTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskTypesController {

    private final TaskTypeService taskTypeService;

    public TaskTypesController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @GetMapping("/taskTypes")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskTypeDto> getAll() {
        return taskTypeService.findAll();
    }
}