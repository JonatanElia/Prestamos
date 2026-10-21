package com.ejemplo.prestamos.Controller;

import com.ejemplo.prestamos.Model.Prestamo;
import com.ejemplo.prestamos.Service.ServiceIMPL.PrestamoServiceImpl;
import com.ejemplo.prestamos.dto.PrestamoRequest;
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
@RequestMapping("/api/prestamo")
public class PrestamoController {
    private final PrestamoServiceImpl prestamoService;
    @PostMapping("/registrar")
    public ResponseEntity<Prestamo> registrarPrestamo(@RequestBody PrestamoRequest prestamo){
        Prestamo nuevoPrestamo = prestamoService.registrar(prestamo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoPrestamo);
    }

    @PostMapping("/listar")
    public ResponseEntity<List<Prestamo>> obetener(){
        List<Prestamo> prestamos = prestamoService.listarTodos();
        return ResponseEntity.ok(prestamos);
    }
}
