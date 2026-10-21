package com.ejemplo.prestamos.Service.ServiceIMPL;


import com.ejemplo.prestamos.Exception.ResourceNoFoundException;
import com.ejemplo.prestamos.Model.Herramienta;
import com.ejemplo.prestamos.Model.Prestamo;
import com.ejemplo.prestamos.Repository.HerramientaRepository;
import com.ejemplo.prestamos.Repository.PrestamoRepository;
import com.ejemplo.prestamos.Service.PrestamoService;
import com.ejemplo.prestamos.dto.PrestamoRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository repository;
    private final HerramientaRepository herramientaRepository;
    @Override
    @Transactional
    public List<Prestamo> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public List<Prestamo> listarPorHerramientaId(Long idHerramienta) {
        return repository.findByHerramientaId(idHerramienta);
    }


    @Override
    @Transactional
    public Prestamo registrar(PrestamoRequest request) {
        if (request.cantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        Herramienta herramienta = herramientaRepository.findById(request.herramientaId())
                .orElseThrow(() -> new ResourceNoFoundException("La herramienta no existe"));

        if (request.cantidad() > herramienta.getCantidad()) {
            throw new IllegalArgumentException("Cantidad superior a las unidades disponibles");
        }

        herramienta.setCantidad(herramienta.getCantidad() - request.cantidad());
        herramientaRepository.save(herramienta);

        Prestamo prestamo = new Prestamo();
        prestamo.setResponsable(request.responsable());
        prestamo.setCantidad(request.cantidad());
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setHerramienta(herramienta);
        return repository.save(prestamo);
    }
}
