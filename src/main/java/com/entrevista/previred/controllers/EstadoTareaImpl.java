package com.entrevista.previred.controllers;

import com.entrevista.previred.services.EstadoTareaService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.EstadosTareaApi;
import org.openapitools.model.EstadoTareaDTO;
import org.openapitools.model.ListaEstadosTarea;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EstadoTareaImpl implements EstadosTareaApi {

    private final EstadoTareaService tareaService;

    @Override
    public ResponseEntity<ListaEstadosTarea> estadosTareaGet() {
        return ResponseEntity.ok(tareaService.obtenerTodosLosEstadosTarea());
    }

    @Override
    public ResponseEntity<EstadoTareaDTO> estadosTareaIdGet(Integer id) {
        return ResponseEntity.ok(tareaService.getTareaById(id));
    }
}
