package com.ejemplo.prestamos.Service;

import com.ejemplo.prestamos.Model.Herramienta;

import java.util.List;

public interface HerramientaService {

    List<Herramienta> listarTodos();


    Herramienta guardar(Herramienta herramienta);


}
