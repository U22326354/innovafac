package com.inovafac.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "precios")
@Data
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "plan_nombre", nullable = false)
    private String planNombre;
    
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
    
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    
    @Column(name = "caracteristicas", length = 2000)
    private String caracteristicas;
    
    @Column(name = "activo")
    private boolean activo = true;
    
    // Constructor por defecto
    public Precio() {}
    
    // Constructor con parámetros
    public Precio(String planNombre, BigDecimal precio, String descripcion, String caracteristicas) {
        this.planNombre = planNombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.activo = true;
    }
}
