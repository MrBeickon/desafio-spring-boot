package com.entrevista.previred.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario") // Ajusta el nombre de la tabla según corresponda
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre_usuario", unique = true) // Aseguramos que sea único
    private String nombreUsuario;

    @Column(name = "contrasena")
    private String contrasena;


    @Column(name = "activo", nullable = false)
    private boolean activo;

    @OneToMany(mappedBy = "usuario")
    private Collection<Tarea> tareas;

    // Relación con la entidad Rol
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "usuario_id"), // Columna que referencia a Usuario
            inverseJoinColumns = @JoinColumn(name = "rol_id") // Columna que referencia a Rol
    )
    private List<Rol> roles;

    // Implementaciones de UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convertimos los roles a GrantedAuthority
        return roles.stream()
                .map(rol -> (GrantedAuthority) rol::getNombre)
                .toList();
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Para simplificar, no manejamos fechas de expiración
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // No manejamos cuentas bloqueadas
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Credenciales no expiran
    }

    @Override
    public boolean isEnabled() {
        return activo; // Determina si el usuario está activo o inactivo
    }
}