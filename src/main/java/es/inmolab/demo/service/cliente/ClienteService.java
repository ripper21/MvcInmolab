package es.inmolab.demo.service.cliente;

import java.util.List;

import org.springframework.ui.Model;

import es.inmolab.demo.entity.Cliente;

public interface ClienteService {

	List<Cliente> obtieneClientesPorTipo(Model model);
	

}
