package es.inmolab.demo.service.cliente;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import es.inmolab.demo.entity.Cliente;
import es.inmolab.demo.repository.ClienteRepository;

@Service
public class ClienteImpl implements ClienteService {
    private static final Logger log = LoggerFactory.getLogger(ClienteImpl.class);
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteImpl(ClienteRepository clienteRepository, BCryptPasswordEncoder passwordEncoder,
                        ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> obtieneClientesPorTipo(Model model) {
        log.info("[obtieneClientesPorTipo] : OBTIENE CLIENTES POR TIPO");
        String tipoCliente = (String) model.getAttribute("tipoCliente");
        return clienteRepository.encontrarClientePorTipo(tipoCliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }
}
