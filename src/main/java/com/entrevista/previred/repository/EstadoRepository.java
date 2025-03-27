package com.entrevista.previred.repository;

import com.entrevista.previred.models.entities.EstadoTarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoTarea, Integer> {
}
