package com.entrevista.previred.mappers;

import com.entrevista.previred.models.entities.EstadoTarea;
import org.openapitools.model.EstadoTareaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoTareaMapper {

    public EstadoTareaDTO toDto(EstadoTarea tarea) {
        return new EstadoTareaDTO()
                .id(tarea.getId())
                .nombre(tarea.getDescripcion());
    }

    public List<EstadoTareaDTO> listToDto(List<EstadoTarea> tareas) {
        return tareas.stream().map(this::toDto).toList();
    }
}
