package com.healthyhabits.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "habits")
public class Habit {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;     
    private String frecuencia; 
    private String objetivo;  

    // Constructors
    public Habit() {}

    public Habit(String nombre, String tipo, String frecuencia, String objetivo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.frecuencia = frecuencia;
        this.objetivo = objetivo;
    }

}
