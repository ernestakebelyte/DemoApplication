package com.example.demoappback.services.tasks;

import com.example.demoappback.entities.Task;
import com.example.demoappback.entities.TaskType;
import com.example.demoappback.errors.NotFound;
import com.example.demoappback.repositories.TaskRepository;
import com.example.demoappback.repositories.TaskTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;
    private final TaskTypeRepository taskTypeRepository;

    public TaskService(TaskRepository taskRepository, TaskTypeRepository taskTypeRepository) {
        this.taskRepository = taskRepository;
        this.taskTypeRepository = taskTypeRepository;
    }

    public List<TaskDto> findAll() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false)
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }
    
    public TaskDto save(TaskDto taskDto) throws Exception {
        Task savedTask = taskRepository.save(mapToEntity(taskDto));
        return mapToDto(savedTask);
    }

    private Task mapToEntity(TaskDto taskDto) throws Exception {
        Task task = new Task();
        Optional<TaskType> taskType = taskTypeRepository.findById(taskDto.getTaskTypeId());
        if (taskType.isEmpty()) {
            logger.error("Task Type can not be found");
            throw new NotFound("Task type not found");
        }
        task.setTaskType(taskType.get());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        return task;
    }

    private TaskDto mapToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskTypeId(task.getTaskType().getId());
        taskDto.setTaskTypeName(task.getTaskType().getName());
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        return taskDto;
    }

}
