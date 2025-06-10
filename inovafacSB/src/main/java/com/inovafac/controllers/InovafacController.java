package com.inovafac.controllers;

import com.inovafac.model.InovafacModel;
import com.inovafac.servicio.InovafacServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller 
@RequestMapping("/")
public class InovafacController {

    @Autowired
    private InovafacServicio inovafacServicio;

    @GetMapping("/")
    public String inicio(Model model) {
        String titulo = "Sistema de Facturación Electrónica - INOVAFAC";
        List<InovafacModel> facturas = inovafacServicio.obtenerTodasLasFacturas();
        double totalGeneral = inovafacServicio.calcularTotalGeneral();
        
        model.addAttribute("titulo", titulo);
        model.addAttribute("facturas", facturas);
        model.addAttribute("totalGeneral", totalGeneral);
        
        return "index"; // Retorna la vista index.html
    }
    
    @GetMapping("/facturas")
    public String listarFacturas(Model model) {
        List<InovafacModel> facturas = inovafacServicio.obtenerTodasLasFacturas();
        model.addAttribute("facturas", facturas);
        model.addAttribute("titulo", "Lista de Facturas");
        return "facturas";
    }
    
    @PostMapping("/nueva-factura")
    public String crearFactura(InovafacModel factura) {
        inovafacServicio.guardarFactura(factura);
        return "redirect:/facturas";
    }
}
