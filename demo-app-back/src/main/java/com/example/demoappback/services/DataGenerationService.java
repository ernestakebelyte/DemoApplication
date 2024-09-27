package com.example.demoappback.services;

import com.example.demoappback.entities.TaskType;
import com.example.demoappback.services.taskTypes.TaskTypeService;
import org.springframework.stereotype.Service;

@Service
public class DataGenerationService {

    private final TaskTypeService taskTypeService;


    public DataGenerationService(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }
    
    public void initData() {
        taskTypeService.save(new TaskType("URGENT", "Urgent"));
        taskTypeService.save(new TaskType("REMINDER", "Reminder"));
        taskTypeService.save(new TaskType("TRIVIAL", "Trivial"));
    }
}
