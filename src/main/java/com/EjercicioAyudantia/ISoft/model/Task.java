package com.EjercicioAyudantia.ISoft.model;

public class Task {

    private Long id;
    private String titulo;
    private String prioridad;
    private String fechaLimite;
    private boolean completada;

    public Task() {}

    public Task(Long id, String prioridad, String titulo, String fechaLimite, boolean completada) {
        this.id = id;
        this.prioridad = prioridad;
        this.titulo = titulo;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
    }

    public Long getId() {return id;}
    public String getPrioridad() {return prioridad;}
    public String getTitulo() {return titulo;}
    public String getFechaLimite() {return fechaLimite;}
    public boolean isCompletada() {return completada;}

    public void setId(Long id) {this.id = id;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setPrioridad(String prioridad) {this.prioridad = prioridad;}
    public void setFechaLimite(String fechaLimite) {this.fechaLimite = fechaLimite;}
    public void setCompletada(boolean completada) {this.completada = completada;}



    @Override
    public String toString() {
        return "Task{" +
                "ID:" + id +
                "Titulo:'" + titulo + '\'' +
                "Prioridad:'" + prioridad + '\'' +
                "Fecha Limite:'" + fechaLimite + '\'' +
                "Completada:" + completada +
                '}';
    }
}
