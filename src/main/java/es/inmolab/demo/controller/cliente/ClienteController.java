package es.inmolab.demo.controller.cliente;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.inmolab.demo.entity.Cliente;
import es.inmolab.demo.service.cliente.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public String clientePorTipo(Model model) {
        List<Cliente> clientes = clienteService.obtieneClientesPorTipo(model);
        model.addAttribute("clientes", clientes);
        return "propiedadesAlquiler";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "agregarPropietario"; // Aquí ajustamos al nombre correcto de la vista
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente"; // Ajusta la ruta de redirección según tus necesidades
    }
    
}

 
    
    
    
    

