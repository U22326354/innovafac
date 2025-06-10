package com.inovafac.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "testimonios")
@Data
public class Testimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "cargo")
    private String cargo;
    
    @Column(name = "empresa")
    private String empresa;
    
    @Column(name = "testimonio", length = 1000)
    private String testimonio;
    
    @Column(name = "foto")
    private String foto;
    
    @Column(name = "activo")
    private boolean activo = true;
    
    // Constructor por defecto
    public Testimonio() {}
    
    // Constructor con parámetros
    public Testimonio(String nombre, String cargo, String empresa, String testimonio, String foto) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
        this.testimonio = testimonio;
        this.foto = foto;
        this.activo = true;
    }
}
