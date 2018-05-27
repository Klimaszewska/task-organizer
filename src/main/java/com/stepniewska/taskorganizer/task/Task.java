package com.stepniewska.taskorganizer.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "task_content", nullable = false)
    @NotEmpty(message = "Add the task description")
    @Length(max = 40)
    private String content;

    @Column(name = "task_category")
    private Integer category;

    @Column(name = "task_status", nullable = false)
    @NotNull
    private TaskStatus status;
}
