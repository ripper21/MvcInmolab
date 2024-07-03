package es.inmolab.demo.service.cliente;

import java.util.List;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Cliente;

public interface ClienteService {
	List<Cliente> obtieneClientesPorTipo(String tipoCliente) throws ServiceException;

	void saveCliente(Cliente cliente) throws ServiceException;

	void deleteCliente(Long id) throws ServiceException;

	void upgradeCliente(Cliente cliente) throws ServiceException;

	List<Cliente> getAllClientes() throws ServiceException;
}
