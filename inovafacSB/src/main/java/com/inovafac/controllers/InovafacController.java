package com.inovafac.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller 
public class InovafacController {

  @GetMapping("/")
  public String inicio(Model model) {

     String titulo = "Inovafac -  probando si funciona el controlador";
    model.addAttribute("titulo", titulo);
    return "index"; // This will resolve to src/main/resources/templates/index.html
  }

}
