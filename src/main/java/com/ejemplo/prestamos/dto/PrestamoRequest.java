package com.ejemplo.prestamos.dto;


import java.time.LocalDate;

public record PrestamoRequest(

        Long herramientaId,

        String responsable,

        LocalDate fechaPrestamo,

        Integer cantidad
) {}