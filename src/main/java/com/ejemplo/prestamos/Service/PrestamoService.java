package com.ejemplo.prestamos.Service;

import com.ejemplo.prestamos.Model.Herramienta;
import com.ejemplo.prestamos.Model.Prestamo;
import com.ejemplo.prestamos.dto.PrestamoRequest;

import java.util.List;

public interface PrestamoService {
    List<Prestamo> listarTodos();

    List<Prestamo> listarPorHerramientaId(Long IdHerramienta);

    Prestamo registrar(PrestamoRequest request);


}
