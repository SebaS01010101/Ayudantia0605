package com.EjercicioAyudantia.ISoft.Controller;

import com.EjercicioAyudantia.ISoft.Model.Task;
import com.EjercicioAyudantia.ISoft.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);

        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTAsks(
            @RequestParam(required = false) String priority,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String limtDate
    ){
        List<Task> tasks = taskService.getTasks(priority, title, limtDate);
        return ResponseEntity.ok(tasks);
    }







}
