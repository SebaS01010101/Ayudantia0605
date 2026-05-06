package com.EjercicioAyudantia.ISoft.Service;

import com.EjercicioAyudantia.ISoft.Model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    List<Task> tasks = new ArrayList<>();

    private final AtomicLong idCounter = new AtomicLong(1);
    public Task createTask(Task task) {
        task.setId(idCounter.getAndIncrement());
        task.setCompleted(false);
        tasks.add(task);
        return task;
    }

}
