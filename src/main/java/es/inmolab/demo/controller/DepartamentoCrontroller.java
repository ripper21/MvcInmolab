package es.inmolab.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.inmolab.demo.entity.Departamento;
import es.inmolab.demo.service.DepartamentoService;
@Controller
@RequestMapping("/departamentos")
public class DepartamentoCrontroller {
    Logger log = LoggerFactory.getLogger(AlquilerController.class);
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/departamentos")
    public String getDepartamentos(Model model) {
        try {
            List<Departamento> departamentos = departamentoService.getAllDepartamentos();
            if (departamentos.isEmpty()) {
                log.info("Lista de departamentos vacía");
            }
            model.addAttribute("departamentos", departamentos);
            return "departamentos";
        } catch (Exception e) {
            log.error("Error al obtener la lista de departamentos", e);
            return "error";
        }
    }

    
    @GetMapping
    public String miMetodoGet() {
        log.info("[GET METODO DESDE EL Departamento]");
        return "departamentos";
    }
    
    @PostMapping
    public String miMetodoPost() {
        log.info("[POST METODO DESDE EL DASHBOARD]");
        return "departamentos";
    }

}
