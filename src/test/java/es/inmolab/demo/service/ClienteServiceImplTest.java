package es.inmolab.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Cliente;
import es.inmolab.demo.repository.ClienteRepository;
import es.inmolab.demo.service.cliente.ClienteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
    }

    @Test
    void obtieneClientesPorTipo() throws ServiceException {
        when(clienteRepository.encontrarClientePorTipo(any(String.class))).thenReturn(Arrays.asList(cliente));

        List<Cliente> result = clienteService.obtieneClientesPorTipo("VIP");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(cliente, result.get(0));
        verify(clienteRepository, times(1)).encontrarClientePorTipo("VIP");
    }

    @Test
    void saveCliente() throws ServiceException {
        doNothing().when(clienteRepository).save(any(Cliente.class));

        clienteService.saveCliente(cliente);

        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void deleteCliente() throws ServiceException {
        doNothing().when(clienteRepository).deleteById(anyLong());

        clienteService.deleteCliente(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    void upgradeCliente() throws ServiceException {
        doNothing().when(clienteRepository).save(any(Cliente.class));

        clienteService.upgradeCliente(cliente);

        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void getAllClientes() throws ServiceException {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));

        List<Cliente> result = clienteService.getAllClientes();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(cliente, result.get(0));
        verify(clienteRepository, times(1)).findAll();
    }
}
