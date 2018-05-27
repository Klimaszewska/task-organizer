package com.stepniewska.taskorganizer.utils;

import com.stepniewska.taskorganizer.task.Task;
import com.stepniewska.taskorganizer.task.TaskRepository;
import com.stepniewska.taskorganizer.task.TaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class PrefillDatabase {

    private TaskRepository taskRepository;

    private static List<String> contentList = Arrays.asList("Walk the dog", "Solve this puzzle", "Keep on coding in Java", "Write a simple Java app", "Answer all the e-mails", "Get the homework done!");
    private static List<Integer> categoryList = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static List<TaskStatus> statusList = Arrays.asList(TaskStatus.TO_DO, TaskStatus.IN_PROGRESS, TaskStatus.DONE);

@PostConstruct
    public void generateTasks(){
        Random random = new Random();
        List<Task> taskList = new ArrayList<>();
        int MAX_TASK_LIST_LENGTH = 20;

        for (int i = 0; i< MAX_TASK_LIST_LENGTH; i++){
            int randomInt = random.nextInt(6);
            int randomStatusInt = random.nextInt(3);
            Task task = Task.builder().content(contentList.get(randomInt)).category(categoryList.get(randomInt)).status(statusList.get(randomStatusInt)).build();
            taskList.add(task);
        }

        for (Task task : taskList) {
            taskRepository.save(task);
        }
    }
}
