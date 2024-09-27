package com.example.demoappback.services.tasks;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskDto {
    
    private Long id;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 100, message = "The length of name must be between 3 and 100 characters.")
    private String name;

    private String description;

    @NotBlank(message = "Task Type Id is required.")
    private Long taskTypeId;

    private String taskTypeName;

    public TaskDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public Long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }
}
