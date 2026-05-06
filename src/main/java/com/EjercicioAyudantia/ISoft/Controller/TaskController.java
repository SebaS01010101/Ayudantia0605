package com.EjercicioAyudantia.ISoft.Controller;

import com.EjercicioAyudantia.ISoft.Model.Task;
import com.EjercicioAyudantia.ISoft.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
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
