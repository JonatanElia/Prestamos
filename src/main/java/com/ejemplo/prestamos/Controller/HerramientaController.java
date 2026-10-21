package com.ejemplo.prestamos.Controller;

import com.ejemplo.prestamos.Model.Herramienta;
import com.ejemplo.prestamos.Service.ServiceIMPL.HerramientaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/Herramienta")
public class HerramientaController {
    private final HerramientaServiceImpl herramientaService;

    @PostMapping("/registrar")
    public ResponseEntity<Herramienta> registrarHerramienta(@RequestBody Herramienta herramienta){
        Herramienta nuevaHerramienta = herramientaService.guardar(herramienta);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaHerramienta);
    }

    @PostMapping("/listar")
    public ResponseEntity<List<Herramienta>> obetener(){
        List<Herramienta> herramientas = herramientaService.listarTodos();
        return ResponseEntity.ok(herramientas);
    }
}
