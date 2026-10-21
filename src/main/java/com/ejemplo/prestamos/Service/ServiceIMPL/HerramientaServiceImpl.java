package com.ejemplo.prestamos.Service.ServiceIMPL;

import com.ejemplo.prestamos.Model.Herramienta;
import com.ejemplo.prestamos.Repository.HerramientaRepository;
import com.ejemplo.prestamos.Service.HerramientaService;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HerramientaServiceImpl implements HerramientaService {

    private final HerramientaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Herramienta> listarTodos() {
        return repository.findAll();
    }


    @Override
    @Transactional
    public Herramienta guardar(Herramienta herramienta) {
        return repository.save(herramienta);
    }

}
