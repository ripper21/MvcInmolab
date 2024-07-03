package es.inmolab.demo.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Cliente;
import es.inmolab.demo.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> obtieneClientesPorTipo(String tipoCliente) throws ServiceException {
        log.info("[obtieneClientesPorTipo] : OBTIENE CLIENTES POR TIPO");
        List<Cliente> clientes = null;
        
        try {
            clientes = clienteRepository.encontrarClientePorTipo(tipoCliente);
            log.info("[clientes:" + clientes + "]");
            if (clientes == null || clientes.isEmpty()) {
                throw new ServiceException("Cliente no encontrado", ErrorCode.CLIENTE_NO_ENCONTRADO);
            }
        } catch (ServiceException se) {
            log.error("[SERVICIO EXCEPTION]", se);
            throw se;
        } catch (Exception e) {
            log.error("[ERROR GENERAL]", e);
            throw new ServiceException("Error general", ErrorCode.ERROR_GENERAL);
        }

        return clientes;
    }

    @Override
    public void saveCliente(Cliente cliente) throws ServiceException {
        log.info("[saveCliente]");
        log.info("[CLIENTE GUARDADO] " + cliente.toString());
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            log.error("[ERROR GENERAL]", e);
            throw new ServiceException("Error al guardar cliente", ErrorCode.ERROR_GENERAL);
        }
    }

    @Override
    public void deleteCliente(Long id) throws ServiceException {
        log.info("[ELIMINAR CLIENTE]");
        log.debug("[CLIENTE ELIMINADO POR ID: " + id + "]");
        try {
            clienteRepository.deleteById(id);
        } catch (Exception e) {
            log.error("[ERROR GENERAL]", e);
            throw new ServiceException("Error al eliminar cliente", ErrorCode.ERROR_GENERAL);
        }
    }

    @Override
    public void upgradeCliente(Cliente cliente) throws ServiceException {
        log.info("[MODIFICAR CLIENTE]");
        log.debug("[MODIFICANDO CLIENTE: " + cliente.toString() + "]");
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            log.error("[ERROR GENERAL]", e);
            throw new ServiceException("Error al modificar cliente", ErrorCode.ERROR_GENERAL);
        }
    }

    @Override
    public List<Cliente> getAllClientes() throws ServiceException {
        log.info("[getAllClientes]");
        List<Cliente> clientes = null;
        try {
            clientes = clienteRepository.findAll();
            log.info("[clientes:" + clientes + "]");
        } catch (Exception e) {
            log.error("[ERROR GENERAL]", e);
            throw new ServiceException("Error al obtener todos los clientes", ErrorCode.ERROR_GENERAL);
        }
        return clientes;
    }
}
