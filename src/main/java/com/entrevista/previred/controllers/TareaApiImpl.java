package com.entrevista.previred.controllers;

import com.entrevista.previred.services.TareaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TareasApi;
import org.openapitools.model.ListaTareas;
import org.openapitools.model.TareaCreateRequest;
import org.openapitools.model.TareaDTO;
import org.openapitools.model.TareaUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TareaApiImpl implements TareasApi {

    private final TareaService tareaService;

    @Override
    public ResponseEntity<ListaTareas> tareasGet() {
        return ResponseEntity.ok(tareaService.obtenerTodasLasTareas());
    }

    @Override
    public ResponseEntity<TareaDTO> tareasIdGet(Integer id) {
        return ResponseEntity.ok(tareaService.getTareaById(id));
    }

    @Override
    public ResponseEntity<TareaDTO> tareasPost(@RequestBody TareaCreateRequest request) {
        return ResponseEntity.ok(tareaService.crearTarea(request));
    }

    @Override
    public ResponseEntity<TareaDTO> tareasIdPut(Integer idTartea, @RequestBody TareaUpdateRequest request) {
        return ResponseEntity.ok(tareaService.actualizarTarea(idTartea,request));
    }

    @Override
    public ResponseEntity<Void> tareasIdDelete(Integer idTartea) {
        return ResponseEntity.ok(tareaService.eliminarTarea(idTartea));
    }

    @Override
    public ResponseEntity<ListaTareas> tareasUsuarioUserIdGet(Integer id) {
        return ResponseEntity.ok(tareaService.getTareaByUserId(id));
    }
}
