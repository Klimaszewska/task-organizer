package com.stepniewska.taskorganizer.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

//    private taskList;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task getById(int id) {
        return taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Task> getAllTasks(){
        List<Task> taskList = taskRepository.findAll();
        if(taskList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return taskList;
    }
    
    public Task update(int id, Task task){
        Task taskToUpdate = getById(id);
        taskToUpdate.setContent(task.getContent());
        taskToUpdate.setCategory(task.getCategory());
        taskToUpdate.setStatus(task.getStatus());
        taskRepository.save(taskToUpdate);
        return taskToUpdate;
    }

    public Task delete(int id){
        Task taskToDelete = getById(id);
        taskRepository.delete(taskToDelete);
        return taskToDelete;
    }

}
