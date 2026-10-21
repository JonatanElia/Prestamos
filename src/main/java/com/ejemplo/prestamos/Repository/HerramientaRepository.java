package com.ejemplo.prestamos.Repository;

import com.ejemplo.prestamos.Model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta,Long> {
}
