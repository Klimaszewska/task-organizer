package com.stepniewska.taskorganizer.task;

public enum TaskStatus {
    TO_DO,
    IN_PROGRESS,
    DONE;


    @Override
    public String toString() {
        return "Status(To do " + TO_DO + ", In progress " + IN_PROGRESS + ", Done " + DONE + ")";
    }
}


