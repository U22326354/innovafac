package com.inovafac.controllers;

import com.inovafac.servicio.LandingPageServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class AdminController {    @Autowired
    private LandingPageServicio landingPageServicio;
    
    @GetMapping("/admin")
    public String admin(Model model) {
        String titulo = "Portal de Administración - INOVAFAC";
        model.addAttribute("titulo", titulo);
          // Cargar todos los datos para administración
        model.addAttribute("servicios", landingPageServicio.obtenerTodosServicios());
        model.addAttribute("precios", landingPageServicio.obtenerTodosPrecios());
        model.addAttribute("testimonios", landingPageServicio.obtenerTodosTestimonios());
        
        return "admin"; // Portal de administrador
    }
      @GetMapping("/admin/servicios")
    public String adminServicios(Model model) {
        String titulo = "Gestión de Servicios - INOVAFAC";
        model.addAttribute("titulo", titulo);
        model.addAttribute("servicios", landingPageServicio.obtenerTodosServicios());
        return "admin-servicios"; // Template específico para servicios
    }
    
    @GetMapping("/admin/precios")
    public String adminPrecios(Model model) {
        String titulo = "Gestión de Precios - INOVAFAC";
        model.addAttribute("titulo", titulo);
        model.addAttribute("precios", landingPageServicio.obtenerTodosPrecios());
        return "admin-precios"; // Template específico para precios
    }
    
    @GetMapping("/admin/testimonios")
    public String adminTestimonios(Model model) {
        String titulo = "Gestión de Testimonios - INOVAFAC";
        model.addAttribute("titulo", titulo);
        model.addAttribute("testimonios", landingPageServicio.obtenerTodosTestimonios());
        return "admin-testimonios"; // Template específico para testimonios
    }
}
