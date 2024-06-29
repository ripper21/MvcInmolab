package es.inmolab.demo.service.cliente;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.ui.Model;

import es.inmolab.demo.entity.Cliente;

public interface ClienteService {

	List<Cliente> obtieneClientesPorTipo(Model model);
	void saveCliente(Cliente cliente);
	void deleteCliente(Long id) throws ServiceException;
	void upgradeCliente(Cliente cliente) throws ServiceException;
	List<Cliente> getAllClientes() throws ServiceException;
	

}
