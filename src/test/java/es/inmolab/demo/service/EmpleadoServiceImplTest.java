package es.inmolab.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.dto.EmpleadoDto;
import es.inmolab.demo.entity.Empleado;
import es.inmolab.demo.repository.EmpleadoRepository;
import es.inmolab.demo.service.empleado.EmpleadoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceImplTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    private Empleado empleado;
    private EmpleadoDto empleadoDto;

    @BeforeEach
    void setUp() {
        empleado = new Empleado(1L, "Juan", "Perez", 1234567890L, new Date(), "juan.perez@example.com", "NIF123", null, null, null);
        empleadoDto = new EmpleadoDto();
    }

    @Test
    void getAllEmpleados() {
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado));
        when(modelMapper.map(any(Empleado.class), eq(EmpleadoDto.class))).thenReturn(empleadoDto);

        List<EmpleadoDto> result = empleadoService.getAllEmpleados();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(empleadoDto, result.get(0));
        verify(empleadoRepository, times(1)).findAll();
    }

    @Test
    void getEmpleadoById() throws ServiceException {
        when(empleadoRepository.findById(anyLong())).thenReturn(Optional.of(empleado));
        when(modelMapper.map(any(Empleado.class), eq(EmpleadoDto.class))).thenReturn(empleadoDto);

        EmpleadoDto result = empleadoService.getEmpleadoById(1L);

        assertNotNull(result);
        assertEquals(empleadoDto, result);
        verify(empleadoRepository, times(1)).findById(1L);
    }


    @Test
    void saveEmpleado() throws ServiceException {
        doNothing().when(empleadoRepository).save(any(Empleado.class));

        empleadoService.saveEmpleado(empleado);

        verify(empleadoRepository, times(1)).save(empleado);
    }

    @Test
    void deleteEmpleado() throws ServiceException {
        doNothing().when(empleadoRepository).deleteById(anyLong());

        empleadoService.deleteEmpleado(1L);

        verify(empleadoRepository, times(1)).deleteById(1L);
    }

    @Test
    void upgradeEmpleado() throws ServiceException {
        doNothing().when(empleadoRepository).save(any(Empleado.class));

        empleadoService.upgradeEmpleado(empleado);

        verify(empleadoRepository, times(1)).save(empleado);
    }
}
