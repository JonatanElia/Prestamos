package com.ejemplo.prestamos.Repository;

import com.ejemplo.prestamos.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Long> {
    List<Prestamo> findByHerramientaId(Long idHerramienta);
}
