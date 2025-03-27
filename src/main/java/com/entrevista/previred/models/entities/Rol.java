package com.entrevista.previred.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rol") // Ajusta el nombre de la tabla según corresponda
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", unique = true, nullable = false) // Rol único, como "ROLE_USER" o "ROLE_ADMIN"
    private String nombre;

}