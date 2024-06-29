package es.inmolab.demo.service.cliente;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.entity.Cliente;
import es.inmolab.demo.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteImpl implements ClienteService {
   
    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public List<Cliente> getAllClientes() throws ServiceException {
        log.info("[getAllClientes]");
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = clienteRepository.findAll();
        } catch (Exception e) {
            log.error("ERROR GENERAL DESDE CLIENTE SERVICE", e);
            throw new ServiceException(ErrorCode.ERROR_GENERAL);
        }
        return clientes;
    }
    
    @Override
    public List<Cliente> obtieneClientesPorTipo(Model model) {
        log.info("[obtieneClientesPorTipo] : OBTIENE CLIENTES POR TIPO");
        String tipoCliente = (String) model.getAttribute("tipoCliente");
        List<Cliente> clientes = null;
        
        try {
            clientes = clienteRepository.encontrarClientePorTipo(tipoCliente);
            if (clientes == null || clientes.isEmpty()) {
                throw new ServiceException(ErrorCode.CLIENTE_NO_ENCONTRADO);
            }
        } catch (ServiceException se) {
            log.error("[SERVICIO EXCEPTION]", se);
            throw se;
        } catch (Exception e) {
            log.error("[ERROR GENERAL]", e);
            throw new ServiceException(ErrorCode.ERROR_GENERAL);
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
            throw new ServiceException(ErrorCode.ERROR_GENERAL);
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
            throw new ServiceException(ErrorCode.ERROR_GENERAL);
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
            throw new ServiceException(ErrorCode.ERROR_GENERAL);
        }
    }
}
