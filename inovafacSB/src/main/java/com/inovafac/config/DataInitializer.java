package com.inovafac.config;

import com.inovafac.model.Servicio;
import com.inovafac.model.Precio;
import com.inovafac.model.Testimonio;
import com.inovafac.repository.ServicioRepository;
import com.inovafac.repository.PrecioRepository;
import com.inovafac.repository.TestimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ServicioRepository servicioRepository;
    
    @Autowired
    private PrecioRepository precioRepository;
    
    @Autowired
    private TestimonioRepository testimonioRepository;

    @Override
    public void run(String... args) throws Exception {
        
        // Inicializar servicios de ejemplo
        if (servicioRepository.count() == 0) {
            Servicio servicio1 = new Servicio();
            servicio1.setNombre("Desarrollo Web");
            servicio1.setDescripcion("Creamos sitios web modernos y responsivos utilizando las últimas tecnologías");
            servicio1.setIcono("fas fa-code");
            servicio1.setActivo(true);
            servicioRepository.save(servicio1);

            Servicio servicio2 = new Servicio();
            servicio2.setNombre("Aplicaciones Móviles");
            servicio2.setDescripcion("Desarrollamos apps nativas e híbridas para iOS y Android");
            servicio2.setIcono("fas fa-mobile-alt");
            servicio2.setActivo(true);
            servicioRepository.save(servicio2);

            Servicio servicio3 = new Servicio();
            servicio3.setNombre("Marketing Digital");
            servicio3.setDescripcion("Estrategias de marketing online para hacer crecer tu negocio");
            servicio3.setIcono("fas fa-chart-line");
            servicio3.setActivo(true);
            servicioRepository.save(servicio3);
        }

        // Inicializar planes de precios
        if (precioRepository.count() == 0) {
            Precio precio1 = new Precio();
            precio1.setPlanNombre("Básico");
            precio1.setPrecio(new BigDecimal("299.99"));
            precio1.setDescripcion("Perfecto para pequeñas empresas que están comenzando");
            precio1.setCaracteristicas("Sitio web de 5 páginas, Diseño responsivo, SEO básico, Soporte 24/7");
            precio1.setActivo(true);
            precioRepository.save(precio1);

            Precio precio2 = new Precio();
            precio2.setPlanNombre("Profesional");
            precio2.setPrecio(new BigDecimal("599.99"));
            precio2.setDescripcion("La opción más popular para empresas en crecimiento");
            precio2.setCaracteristicas("Sitio web ilimitado, E-commerce, SEO avanzado, Marketing digital, Soporte prioritario");
            precio2.setActivo(true);
            precioRepository.save(precio2);

            Precio precio3 = new Precio();
            precio3.setPlanNombre("Empresarial");
            precio3.setPrecio(new BigDecimal("999.99"));
            precio3.setDescripcion("Solución completa para grandes empresas");
            precio3.setCaracteristicas("Todo del plan Profesional, Aplicación móvil, Integraciones personalizadas, Consultor dedicado");
            precio3.setActivo(true);
            precioRepository.save(precio3);
        }        // Inicializar testimonios
        if (testimonioRepository.count() == 0) {
            Testimonio testimonio1 = new Testimonio();
            testimonio1.setNombre("María González");
            testimonio1.setCargo("CEO");
            testimonio1.setEmpresa("TechSolutions");
            testimonio1.setTestimonio("InovaFac transformó completamente nuestro negocio. Su equipo es excepcional y los resultados superaron nuestras expectativas.");
            testimonio1.setFoto("web/assets/img/testimonial/testimonial-1.png");
            testimonio1.setActivo(true);
            testimonioRepository.save(testimonio1);

            Testimonio testimonio2 = new Testimonio();
            testimonio2.setNombre("Carlos Rodríguez");
            testimonio2.setCargo("Director de Marketing");
            testimonio2.setEmpresa("Digital Innovate");
            testimonio2.setTestimonio("La calidad del trabajo y la atención al detalle de InovaFac es impresionante. Definitivamente recomendaría sus servicios.");
            testimonio2.setFoto("web/assets/img/testimonial/testimonial-2.png");
            testimonio2.setActivo(true);
            testimonioRepository.save(testimonio2);

            Testimonio testimonio3 = new Testimonio();
            testimonio3.setNombre("Ana Martínez");
            testimonio3.setCargo("Fundadora");
            testimonio3.setEmpresa("StartupPlus");
            testimonio3.setTestimonio("Trabajar con InovaFac fue una experiencia increíble. Su profesionalismo y expertise nos ayudaron a alcanzar nuestros objetivos.");
            testimonio3.setFoto("web/assets/img/testimonial/testimonial-3.png");
            testimonio3.setActivo(true);
            testimonioRepository.save(testimonio3);
        }
        
        System.out.println("✅ Datos de ejemplo inicializados correctamente");
    }
}
