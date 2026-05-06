package com.EjercicioAyudantia.ISoft.Service;

import com.EjercicioAyudantia.ISoft.Model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks(String priority, String title, String limitDate) {
        return tasks.stream()
                .filter(task -> priority == null || task.getPriority().equalsIgnoreCase(priority))
                .filter(task -> title == null || task.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(task -> limitDate == null || task.getLimitDate().equals(limitDate))
                .collect(Collectors.toList());
    }


    private final AtomicLong idCounter = new AtomicLong(1);
    public Task createTask(Task task) {
        task.setId(idCounter.getAndIncrement());
        task.setCompleted(false);
        tasks.add(task);
        return task;
    }

}
