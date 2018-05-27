package com.stepniewska.taskorganizer.task;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TaskController {
    private TaskService taskService;

    @GetMapping
    public Task getById(@PathVariable("id") int id){
        return taskService.getById(id);
    }

}
