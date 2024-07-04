package es.inmolab.demo.controller;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.inmolab.demo.dto.EmpleadoDto;
import es.inmolab.demo.service.empleado.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/empleados")
public class EmpleadosController {


    private final EmpleadoService empleadoService;
    private final MessageSource messageSource;

    @Autowired
    public EmpleadosController(EmpleadoService empleadoService, MessageSource messageSource) {
        this.empleadoService = empleadoService;
        this.messageSource = messageSource;
    }

    @GetMapping("/listar")
    public String listarEmpleados(Model model, HttpServletRequest request) {
        List<EmpleadoDto> empleados = empleadoService.getAllEmpleados();
        model.addAttribute("empleados", empleados);

        List<Integer> edades = empleados.stream()
                .map(e -> Period.between(e.getFechNac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears())
                .collect(Collectors.toList());
        model.addAttribute("edades", edades);
        
        List<String> nombres = empleados.stream()
                .map(EmpleadoDto::getNombre)
                .collect(Collectors.toList());
        model.addAttribute("nombres", nombres);

        Locale locale = request.getLocale();
        List<String> months = Arrays.asList(
                messageSource.getMessage("month.jan", null, locale),
                messageSource.getMessage("month.feb", null, locale),
                messageSource.getMessage("month.mar", null, locale),
                messageSource.getMessage("month.apr", null, locale),
                messageSource.getMessage("month.may", null, locale),
                messageSource.getMessage("month.jun", null, locale),
                messageSource.getMessage("month.jul", null, locale),
                messageSource.getMessage("month.aug", null, locale),
                messageSource.getMessage("month.sep", null, locale),
                messageSource.getMessage("month.oct", null, locale),
                messageSource.getMessage("month.nov", null, locale),
                messageSource.getMessage("month.dec", null, locale)
        );
        model.addAttribute("months", months);

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
