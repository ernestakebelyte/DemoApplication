package com.example.demoappback.controllers;

import com.example.demoappback.services.tasks.TaskDto;
import com.example.demoappback.services.tasks.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskDto> getAll() {
        return taskService.findAll();
    }

    @PostMapping("/tasks")
    @ResponseStatus(value = HttpStatus.OK)
    public TaskDto save(@Valid @RequestBody TaskDto taskDto) throws Exception {
        return taskService.save(taskDto);
    }
}
