package com.healthyhabits.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HabitDTO {
    // Getters y Setters
    private Long id;
    @NotBlank(message = "El nombre no debe estar vacío")
    private String nombre;
    @NotBlank(message = "El tipo es obligatorio")
    @Pattern(regexp = "Salud Física|Mental|Alimentación", message = "El tipo debe ser: Salud Física, Mental o Alimentación")
    private String tipo;
    @NotBlank(message = "La frecuencia es obligatoria")
    @Pattern(regexp = "Diario|Semanal|Mensual", message = "La frecuencia debe ser: Diario, Semanal o Mensual")
    private String frecuencia;
    private String objetivo;

    // Constructors
    public HabitDTO() {}

    public HabitDTO(Long id, String nombre, String tipo, String frecuencia, String objetivo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.frecuencia = frecuencia;
        this.objetivo = objetivo;
    }

}
