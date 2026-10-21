package com.ejemplo.prestamos.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="Prestamos")
@Data
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    @NotBlank
    private String responsable;

    @NotBlank
    private LocalDate fechaPrestamo;

    @NotBlank
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramienta herramienta;

}
