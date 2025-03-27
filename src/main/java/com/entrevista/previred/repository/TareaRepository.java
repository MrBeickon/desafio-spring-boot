package com.entrevista.previred.repository;

import com.entrevista.previred.models.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
