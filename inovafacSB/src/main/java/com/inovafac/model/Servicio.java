package com.inovafac.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "servicios")
@Data
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    @Column(name = "icono")
    private String icono;
    
    @Column(name = "activo")
    private boolean activo = true;
    
    // Constructor por defecto
    public Servicio() {}
    
    // Constructor con parámetros
    public Servicio(String nombre, String descripcion, String icono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.activo = true;
    }
}
