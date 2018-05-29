package com.stepniewska.taskorganizer.task;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;


    @NotEmpty(message = "Add the task description")
    @Length(max = 200)
    @Column(name = "task_content", nullable = false)
    private String content;

    @Column(name = "task_category")
    private Integer category;

    @NotNull
    @Column(name = "task_status", nullable = false)
    private TaskStatus status;
}
