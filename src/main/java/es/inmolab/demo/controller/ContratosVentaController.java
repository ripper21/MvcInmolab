package es.inmolab.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/contratoVentaList")
public class ContratosVentaController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
    @GetMapping
    public String miMetodoGet() {
        log.info("[GET METODO DESDE EL propiedadesAlquiler]");
        return "contratoVentaList";
    }
    
    @PostMapping
    public String miMetodoPost() {
        log.info("[POST METODO DESDE EL DASHBOARD]");
        return "contratoVentaList";
    }
	

}
