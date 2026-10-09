package com.EjercicioAyudantia.ISoft.service;

import com.EjercicioAyudantia.ISoft.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tareas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public List<Task> listar(String prioridad, String titulo, String fechaLimite) {
        return tareas.stream()
                .filter(t -> prioridad == null || t.getPrioridad().equalsIgnoreCase(prioridad))
                .filter(t -> titulo == null || t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .filter(t -> fechaLimite == null || fechaLimite.equals(t.getFechaLimite()))
                .toList();
    }
}