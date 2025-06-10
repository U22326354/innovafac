package com.inovafac.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "facturas")
@Data
public class InovafacModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero_factura", nullable = false)
    private String numeroFactura;
    
    @Column(name = "cliente", nullable = false)
    private String cliente;
    
    @Column(name = "total", nullable = false)
    private Double total;
    
    @Column(name = "fecha_emision")
    private String fechaEmision;
    
    // Constructor por defecto
    public InovafacModel() {}
    
    // Constructor con parámetros
    public InovafacModel(String numeroFactura, String cliente, Double total, String fechaEmision) {
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.total = total;
        this.fechaEmision = fechaEmision;
    }
}
