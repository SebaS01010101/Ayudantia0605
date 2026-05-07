package com.EjercicioAyudantia.ISoft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static List<Task> tasks = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task nueva = new Task(task.getTitulo(), task.getPrioridad(), task.getFechaLimite());
        tasks.add(nueva);
        return ResponseEntity.status(201).body(nueva);
    }
    
@PatchMapping("/{id}/complete")
public ResponseEntity<Task> completeTask(@PathVariable Long id) {
    return tasks.stream()
        .filter(t -> t.getId().equals(id))
        .findFirst()
        .map(t -> {
            t.setCompletada(true);
            return ResponseEntity.ok(t);
        })
        .orElse(ResponseEntity.notFound().build());
}
}