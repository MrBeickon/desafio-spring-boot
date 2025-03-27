package com.entrevista.previred.services;

import com.entrevista.previred.mappers.TareaMapper;
import com.entrevista.previred.models.entities.Tarea;
import com.entrevista.previred.repository.EstadoRepository;
import com.entrevista.previred.repository.TareaRepository;
import com.entrevista.previred.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.ListaTareas;
import org.openapitools.model.TareaCreateRequest;
import org.openapitools.model.TareaDTO;
import org.openapitools.model.TareaUpdateRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TareaService {
    private final TareaRepository tareaRepository;
    private final EstadoRepository estadoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TareaMapper tareaMapper;


    public ListaTareas obtenerTodasLasTareas() {
        return new ListaTareas().tareas(tareaMapper.listToDto(tareaRepository.findAll()));
    }


    public TareaDTO getTareaById(Integer id) {
        return tareaMapper.toDto(tareaRepository.findById(id).orElseThrow());
    }
    public ListaTareas getTareaByUserId(Integer id) {

        var usuario = usuarioRepository.findById(id.longValue())
                .orElseThrow();

        return new ListaTareas().tareas(tareaMapper.listToDto(usuario.getTareas().stream().toList()));
    }

    public TareaDTO crearTarea(TareaCreateRequest request) {
        var tarea = new Tarea();
        var estado = estadoRepository.findById(request.getEstadoId()).orElseThrow();
        var usurio = usuarioRepository.findById(request.getUsuarioId().longValue()).orElseThrow();

        tarea.setDescripcion(request.getDescripcion());
        tarea.setEstado(estado);
        tarea.setFechaVencimiento(request.getFechaVencimiento());
        tarea.setUsuario(usurio);

        return tareaMapper.toDto(tareaRepository.save(tarea));
    }

    public TareaDTO actualizarTarea(Integer idTarea, TareaUpdateRequest request) {

        var tarea = tareaRepository.findById(idTarea).orElseThrow();
        var estado = estadoRepository.findById(request.getEstadoId()).orElseThrow();

        tarea.setDescripcion(request.getDescripcion());
        tarea.setEstado(estado);
        tarea.setFechaVencimiento(request.getFechaVencimiento());

        return tareaMapper.toDto(tareaRepository.save(tarea));
    }

    public Void eliminarTarea(Integer idTarea) {

        tareaRepository.deleteById(idTarea);
        return null;
    }
}
