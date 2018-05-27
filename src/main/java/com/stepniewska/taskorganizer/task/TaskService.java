package com.stepniewska.taskorganizer.task;

import com.stepniewska.taskorganizer.utils.PrefillDatabase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task getById(int id) {
        return taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
