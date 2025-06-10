package com.inovafac.servicio;

import com.inovafac.model.InovafacModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InovafacServicio {
    
    // Simulamos una base de datos en memoria
    private List<InovafacModel> facturas = new ArrayList<>();
    
    // Constructor que inicializa datos de ejemplo
    public InovafacServicio() {
        facturas.add(new InovafacModel("F001-001", "Juan Pérez", 1500.00, "2025-06-09"));
        facturas.add(new InovafacModel("F001-002", "María García", 2300.50, "2025-06-09"));
        facturas.add(new InovafacModel("F001-003", "Carlos López", 850.75, "2025-06-09"));
    }
    
    public List<InovafacModel> obtenerTodasLasFacturas() {
        return facturas;
    }
    
    public InovafacModel buscarPorId(Long id) {
        return facturas.stream()
                .filter(factura -> factura.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public void guardarFactura(InovafacModel factura) {
        // Simular autoincremento de ID
        factura.setId((long) (facturas.size() + 1));
        facturas.add(factura);
    }
    
    public double calcularTotalGeneral() {
        return facturas.stream()
                .mapToDouble(InovafacModel::getTotal)
                .sum();
    }
}
