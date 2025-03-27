package com.entrevista.previred.loader;

import com.entrevista.previred.models.entities.EstadoTarea;
import com.entrevista.previred.models.entities.Rol;
import com.entrevista.previred.models.entities.Usuario;
import com.entrevista.previred.repository.EstadoRepository;
import com.entrevista.previred.repository.RolRepository;
import com.entrevista.previred.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {

    @Bean
    @Order(1)

    CommandLineRunner preloadRol(RolRepository rolRepository) {
        return args -> {
            if (rolRepository.count() == 0) {
                // Pre-cargar roles sólo si están vacíos
                rolRepository.save(new Rol(null, "ADMIN"));
                rolRepository.save(new Rol(null, "USER"));
            }
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner preloadUsuarios(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        return args -> {
            if (usuarioRepository.count() == 0) {
                // Obtener los roles desde la base de datos
                var adminRol = rolRepository.findByNombre("ADMIN")
                        .orElseThrow(() -> new RuntimeException("El rol ADMIN no fue encontrado"));
                var userRol = rolRepository.findByNombre("USER")
                        .orElseThrow(() -> new RuntimeException("El rol USER no fue encontrado"));

                // Crear usuarios con roles específicos
                usuarioRepository.save(new Usuario(
                        null,
                        "Pepito",
                        "Perez",
                        "PePe", // Nombre de usuario para el administrador
                        new BCryptPasswordEncoder().encode("12345"), // Contraseña encriptada
                        true, // Usuario activo
                        null,
                        List.of(adminRol)
                ));

                usuarioRepository.save(new Usuario(
                        null,
                        "Juan",
                        "Martin",
                        "Equisde",
                        new BCryptPasswordEncoder().encode("12345"),
                        true,
                        null,
                        List.of(userRol) // Rol de USER
                ));

                usuarioRepository.save(new Usuario(
                        null,
                        "Roberto",
                        "Saavedra",
                        "Topo",
                        new BCryptPasswordEncoder().encode("12345"),
                        true,
                        null,
                        List.of(userRol) // Rol de USER
                ));
            }
        };
    }

    @Bean
    @Order(3)
    CommandLineRunner preloadEstados(EstadoRepository estadoRepository) {
        return args -> {
            if (estadoRepository.count() == 0) { // Solo carga si está vacío
                estadoRepository.save(new EstadoTarea(null, "Pendiente"));
                estadoRepository.save(new EstadoTarea(null, "En progreso"));
                estadoRepository.save(new EstadoTarea(null, "Completado"));
                estadoRepository.save(new EstadoTarea(null, "Cancelado"));
            }
        };
    }
}
