package com.entrevista.previred.services;

import com.entrevista.previred.mappers.EstadoTareaMapper;
import com.entrevista.previred.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.EstadoTareaDTO;
import org.openapitools.model.ListaEstadosTarea;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EstadoTareaService {
    private final EstadoRepository estadoTareaRepository;
    private final EstadoTareaMapper estadoTareaMapper;


    public ListaEstadosTarea obtenerTodosLosEstadosTarea() {
        return new ListaEstadosTarea().tareas(estadoTareaMapper.listToDto(estadoTareaRepository.findAll()));
    }

    public EstadoTareaDTO getTareaById(Integer id) {
        return estadoTareaMapper.toDto(estadoTareaRepository.findById(id).orElseThrow());
    }
}
