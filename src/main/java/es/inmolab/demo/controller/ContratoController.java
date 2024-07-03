package es.inmolab.demo.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.dto.ContratoDto;
import es.inmolab.demo.entity.Contrato;
import es.inmolab.demo.service.contrato.ContratoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    @Autowired
    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping
    public String getAllContratos(Model model) {
        log.info("GET /contratos");
        try {
            List<ContratoDto> contratos = contratoService.getAllContrato();
            model.addAttribute("contratos", contratos);
            return "contratos/list"; // Devuelve la vista 'list.html' en el directorio 'contratos'
        } catch (ServiceException e) {
            log.error("Error al recuperar todos los contratos", e);
            model.addAttribute("error", "Error al recuperar todos los contratos");
            return "error"; // Devuelve una vista de error
        }
    }

    @GetMapping("/fecha-creacion")
    public String getContratosByFechaCreacion(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaCreacion, Model model) {
        log.info("GET /contratos/fecha-creacion?fecha=" + fechaCreacion);
        try {
            List<ContratoDto> contratos = contratoService.getContratoByFechaCreacion(fechaCreacion);
            model.addAttribute("contratos", contratos);
            return "contratos/list"; // Devuelve la vista 'list.html' en el directorio 'contratos'
        } catch (ServiceException e) {
            log.error("Error al recuperar contratos por fecha de creación", e);
            model.addAttribute("error", "Error al recuperar contratos por fecha de creación");
            return "error"; // Devuelve una vista de error
        }
    }

    @GetMapping("/fecha-entrada")
    public String getContratosByFechaEntrada(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaEntrada, Model model) {
        log.info("GET /contratos/fecha-entrada?fecha=" + fechaEntrada);
        try {
            List<ContratoDto> contratos = contratoService.getContratoByFechaEntrada(fechaEntrada);
            model.addAttribute("contratos", contratos);
            return "contratos/list"; // Devuelve la vista 'list.html' en el directorio 'contratos'
        } catch (ServiceException e) {
            log.error("Error al recuperar contratos por fecha de entrada", e);
            model.addAttribute("error", "Error al recuperar contratos por fecha de entrada");
            return "error"; // Devuelve una vista de error
        }
    }

    @GetMapping("/fecha-salida")
    public String getContratosByFechaSalida(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaSalida, Model model) {
        log.info("GET /contratos/fecha-salida?fecha=" + fechaSalida);
        try {
            List<ContratoDto> contratos = contratoService.getContratoByFechaSalida(fechaSalida);
            model.addAttribute("contratos", contratos);
            return "contratos/list"; // Devuelve la vista 'list.html' en el directorio 'contratos'
        } catch (ServiceException e) {
            log.error("Error al recuperar contratos por fecha de salida", e);
            model.addAttribute("error", "Error al recuperar contratos por fecha de salida");
            return "error"; // Devuelve una vista de error
        }
    }

    @GetMapping("/{id}")
    public String getContratoById(@PathVariable("id") Long id, Model model) {
        log.info("GET /contratos/" + id);
        try {
            ContratoDto contrato = contratoService.getContratoByNroContrato(id);
            model.addAttribute("contrato", contrato);
            return "contratos/detail"; // Devuelve la vista 'detail.html' en el directorio 'contratos'
        } catch (ServiceException e) {
            log.error("Error al recuperar contrato por ID", e);
            model.addAttribute("error", "Error al recuperar contrato por ID");
            return "error"; // Devuelve una vista de error
        }
    }

    @PostMapping
    public String saveContrato(@ModelAttribute Contrato contrato, Model model) {
        log.info("POST /contratos");
        try {
            contratoService.saveContrato(contrato);
            return "redirect:/contratos"; // Redirige a la lista de contratos
        } catch (ServiceException e) {
            log.error("Error al guardar contrato", e);
            model.addAttribute("error", "Error al guardar contrato");
            return "error"; // Devuelve una vista de error
        }
    }

    @PutMapping("/{id}")
    public String updateContrato(@PathVariable("id") Long id, @ModelAttribute Contrato contrato, Model model) {
        log.info("PUT /contratos/" + id);
        try {
            contrato.setIdContrato(id);  // Asegúrate de que el ID está configurado correctamente
            contratoService.upgradeContrato(contrato);
            return "redirect:/contratos"; // Redirige a la lista de contratos
        } catch (ServiceException e) {
            log.error("Error al actualizar contrato", e);
            model.addAttribute("error", "Error al actualizar contrato");
            return "error"; // Devuelve una vista de error
        }
    }

    @DeleteMapping("/{id}")
    public String deleteContrato(@PathVariable("id") Long id, Model model) {
        log.info("DELETE /contratos/" + id);
        try {
            contratoService.deleteContrato(id);
            return "redirect:/contratos"; // Redirige a la lista de contratos
        } catch (ServiceException e) {
            log.error("Error al eliminar contrato", e);
            model.addAttribute("error", "Error al eliminar contrato");
            return "error"; // Devuelve una vista de error
        }
    }
}
