package com.EjercicioAyudantia.ISoft.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    private Long id;
    private String title;
    private String priority;
    private String limitDate;
    private String completed;
}
