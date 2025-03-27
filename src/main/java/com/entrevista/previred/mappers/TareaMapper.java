package com.entrevista.previred.mappers;

import com.entrevista.previred.models.entities.Tarea;
import org.openapitools.model.TareaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TareaMapper {

    public TareaDTO toDto(Tarea tarea) {
        return new TareaDTO()
                .id(tarea.getId())
                .estado(tarea.getEstado().getDescripcion())
                .descripcion(tarea.getDescripcion())
                .fechaVencimiento(tarea.getFechaVencimiento())
                .usuario(tarea.getUsuario().getNombreUsuario());
    }

    public List<TareaDTO> listToDto(List<Tarea> tareas) {
        return tareas.stream().map(this::toDto).toList();
    }
}
