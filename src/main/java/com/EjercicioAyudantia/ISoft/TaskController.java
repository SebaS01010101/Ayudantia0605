package com.EjercicioAyudantia.ISoft;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> f71a781591e520a0fd170b248cfa3c9e1ae43ca6
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
<<<<<<< HEAD

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(
        @RequestParam(required = false) String prioridad,
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) String fechaLimite) {

        List<Task> resultado = tasks.stream()
            .filter(t -> prioridad == null || t.getPrioridad().equalsIgnoreCase(prioridad))
            .filter(t -> titulo == null || t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
            .filter(t -> fechaLimite == null || t.getFechaLimite().equals(fechaLimite))
            .collect(Collectors.toList());

        return ResponseEntity.ok(resultado);
    }
=======
    
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
>>>>>>> f71a781591e520a0fd170b248cfa3c9e1ae43ca6
}