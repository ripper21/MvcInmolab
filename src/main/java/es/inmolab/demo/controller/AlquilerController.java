package es.inmolab.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/propiedadesAlquiler")
public class AlquilerController {
    
    Logger log = LoggerFactory.getLogger(AlquilerController.class);
    
    @GetMapping
    public String miMetodoGet() {
        log.info("[GET METODO DESDE EL propiedadesAlquiler]");
        return "propiedadesAlquiler";
    }
    
    @PostMapping
    public String miMetodoPost() {
        log.info("[POST METODO DESDE EL DASHBOARD]");
        return "propiedadesAlquiler";
    }
}
