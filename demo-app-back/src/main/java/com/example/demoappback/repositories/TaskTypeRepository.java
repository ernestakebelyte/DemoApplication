package com.example.demoappback.repositories;

import com.example.demoappback.entities.TaskType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTypeRepository  extends CrudRepository<TaskType, Long> {
    
}
