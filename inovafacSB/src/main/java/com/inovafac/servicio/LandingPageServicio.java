package com.inovafac.servicio;

import com.inovafac.model.*;
import com.inovafac.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

@Service
public class LandingPageServicio {
    
    @Autowired(required = false)
    private ServicioRepository servicioRepository;
    
    @Autowired(required = false) 
    private PrecioRepository precioRepository;
    
    @Autowired(required = false)
    private TestimonioRepository testimonioRepository;
    
    // Métodos para Servicios
    public List<Servicio> obtenerServiciosActivos() {
        if (servicioRepository != null) {
            return servicioRepository.findByActivoTrue();
        }
        // Datos de ejemplo cuando no hay base de datos
        List<Servicio> servicios = new ArrayList<>();
        servicios.add(new Servicio("Facturación Electrónica", "Sistema completo de facturación para empresas peruanas con integración SUNAT", "lni-receipt"));
        servicios.add(new Servicio("Contabilidad", "Gestión contable integral con reportes automáticos y cumplimiento tributario", "lni-calculator"));
        servicios.add(new Servicio("Inventario", "Control de stock y productos en tiempo real con kardex automatizado", "lni-package"));
        return servicios;
    }
    
    public List<Servicio> obtenerTodosServicios() {
        if (servicioRepository != null) {
            return servicioRepository.findAll();
        }
        return obtenerServiciosActivos();
    }
    
    public Servicio guardarServicio(Servicio servicio) {
        if (servicioRepository != null) {
            return servicioRepository.save(servicio);
        }
        return servicio; // Simulación
    }
    
    // Métodos para Precios
    public List<Precio> obtenerPreciosActivos() {
        if (precioRepository != null) {
            return precioRepository.findByActivoTrue();
        }
        // Datos de ejemplo cuando no hay base de datos
        List<Precio> precios = new ArrayList<>();
        precios.add(new Precio("Plan Básico", new BigDecimal("29.00"), "Ideal para pequeñas empresas", "Hasta 50 facturas mensuales,1 usuario,Soporte básico,Reportes básicos"));
        precios.add(new Precio("Plan Standard", new BigDecimal("56.00"), "Para empresas en crecimiento", "Facturas ilimitadas,5 usuarios,Soporte 24/7,Reportes avanzados,Integración bancaria"));
        precios.add(new Precio("Plan Premium", new BigDecimal("89.00"), "Para grandes empresas", "Todo incluido,Usuarios ilimitados,Soporte prioritario,API completa,Personalización"));
        return precios;
    }
    
    public List<Precio> obtenerTodosPrecios() {
        if (precioRepository != null) {
            return precioRepository.findAll();
        }
        return obtenerPreciosActivos();
    }
    
    public Precio guardarPrecio(Precio precio) {
        if (precioRepository != null) {
            return precioRepository.save(precio);
        }
        return precio; // Simulación
    }
    
    // Métodos para Testimonios
    public List<Testimonio> obtenerTestimoniosActivos() {
        if (testimonioRepository != null) {
            return testimonioRepository.findByActivoTrue();
        }        // Datos de ejemplo cuando no hay base de datos
        List<Testimonio> testimonios = new ArrayList<>();
        testimonios.add(new Testimonio("María González", "CEO", "TechSolutions", "InovaFac transformó completamente nuestro negocio. Su equipo es excepcional y los resultados superaron nuestras expectativas.", "/web/assets/img/testimonial/testimonial-1.jpg"));
        testimonios.add(new Testimonio("Carlos Rodríguez", "Director de Marketing", "Digital Innovate", "La calidad del trabajo y la atención al detalle de InovaFac es impresionante. Definitivamente recomendaría sus servicios.", "/web/assets/img/testimonial/testimonial-2.jpg"));
        testimonios.add(new Testimonio("Ana Martínez", "Fundadora", "StartupPlus", "Trabajar con InovaFac fue una experiencia increíble. Su profesionalismo y expertise nos ayudaron a alcanzar nuestros objetivos.", "/web/assets/img/testimonial/testimonial-3.jpg"));
        return testimonios;
    }
    
    public List<Testimonio> obtenerTodosTestimonios() {
        if (testimonioRepository != null) {
            return testimonioRepository.findAll();
        }
        return obtenerTestimoniosActivos();
    }
    
    public Testimonio guardarTestimonio(Testimonio testimonio) {
        if (testimonioRepository != null) {
            return testimonioRepository.save(testimonio);
        }
        return testimonio; // Simulación
    }
}
