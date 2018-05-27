package com.stepniewska.taskorganizer.task;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {
    private TaskService taskService;

    @GetMapping(path = "/{id}")
    public Task getById(@PathVariable("id") int id){
        return taskService.getById(id);
    }

    @GetMapping(path = "/")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping(path = "/")
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

}
