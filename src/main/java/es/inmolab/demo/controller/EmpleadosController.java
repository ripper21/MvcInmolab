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

import es.inmolab.demo.entity.Empleado;
import es.inmolab.demo.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
	   Logger log = LoggerFactory.getLogger(EmpleadosController.class);

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/listar")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleadosList";  // Retorna a empleadosList.html
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
