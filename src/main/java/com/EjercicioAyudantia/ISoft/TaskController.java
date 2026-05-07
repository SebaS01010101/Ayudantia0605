package com.EjercicioAyudantia.ISoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static List<Task> tasks = new ArrayList<>();

    // Endpoint de tu compañero A
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task nueva = new Task(task.getTitulo(), task.getPrioridad(), task.getFechaLimite());
        tasks.add(nueva);
        return ResponseEntity.status(201).body(nueva);
    }

    // Tu endpoint (Filtros)
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

    // Endpoint de completar tarea
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