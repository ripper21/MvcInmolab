package es.inmolab.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Propiedad;
import es.inmolab.demo.service.propiedad.PropiedadService;

@Controller
@RequestMapping("/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    @GetMapping
    public String listAllPropiedades(Model model) {
        try {
			model.addAttribute("propiedades", propiedadService.getAllPropiedades());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "propiedades/lista";
    }

    @GetMapping("/nueva")
    public String muestraFormularioAdd(Model model) {
        Propiedad propiedad = new Propiedad();
        model.addAttribute("propiedad", propiedad);
        return "propiedades/formularioPropiedad";
    }

    @PostMapping("/guardar")
    public String guardaPropiedad(@ModelAttribute("propiedad") Propiedad propiedad) throws ServiceException {
        propiedadService.savePropiedad(propiedad);
        return "redirect:/propiedades";
    }

    @GetMapping("/editar/{id}")
    public String muestraFormularioUpdate(@PathVariable("id") long id, Model model) throws ServiceException {
        Propiedad propiedad = propiedadService.getPropiedadById(id);
        model.addAttribute("propiedad", propiedad);
        return "propiedades/formularioPropiedad";
    }

    @GetMapping("/eliminar/{id}")
    public String emilinaPropiedad(@PathVariable("id") long id) throws ServiceException {
        propiedadService.deletePropiedad(id);
        return "redirect:/propiedades";
    }
}
