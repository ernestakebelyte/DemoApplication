package com.example.demoappback.services.taskTypes;

import com.example.demoappback.entities.TaskType;
import com.example.demoappback.repositories.TaskTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskTypeService {

    private final TaskTypeRepository repository;


    public TaskTypeService(TaskTypeRepository repository) {
        this.repository = repository;
    }

    public TaskType save(TaskType taskType) {
        return repository.save(taskType);
    }

    public List<TaskTypeDto> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(type -> new TaskTypeDto(type.getId(), type.getName()))
                .collect(Collectors.toList());
       
    }
}
