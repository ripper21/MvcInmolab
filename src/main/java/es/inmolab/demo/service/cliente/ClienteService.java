package es.inmolab.demo.service.cliente;

import java.util.List;

import es.inmolab.demo.entity.Cliente;
import es.inmolab.demo.common.exception.ServiceException;

public interface ClienteService {

    List<Cliente> obtieneClientesPorTipo(String tipoCliente);
    void saveCliente(Cliente cliente);
    void deleteCliente(Long id) throws ServiceException;
    void upgradeCliente(Cliente cliente) throws ServiceException;
    List<Cliente> getAllClientes() throws ServiceException;
}
