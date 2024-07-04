package es.inmolab.demo.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.dto.ContratoDto;
import es.inmolab.demo.entity.Contrato;
import es.inmolab.demo.repository.ContratoRepository;
import es.inmolab.demo.service.contrato.ContratoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ContratoServiceImplTest {

    @Mock
    private ContratoRepository contratoRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ContratoServiceImpl contratoService;

    private Contrato contrato;
    private ContratoDto contratoDto;
    private Date date;

    @BeforeEach
    void setUp() {
        date = new Date();
        contrato = new Contrato();
        contrato.setIdContrato(1L);
        contrato.setFechCreacion(date);

        contratoDto = new ContratoDto();
        contratoDto.setIdContrato(1L);
        contratoDto.setFechCreacion(date);
    }

    @Test
    void getAllContrato() throws ServiceException {
        when(contratoRepository.findAll()).thenReturn(Arrays.asList(contrato));
        when(modelMapper.map(any(Contrato.class), eq(ContratoDto.class))).thenReturn(contratoDto);

        List<ContratoDto> result = contratoService.getAllContrato();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(contratoDto, result.get(0));
        verify(contratoRepository, times(1)).findAll();
    }

    @Test
    void getContratoByFechaCreacion() throws ServiceException {
        when(contratoRepository.findByFechaCreacion(any(Date.class))).thenReturn(Arrays.asList(contrato));
        when(modelMapper.map(any(Contrato.class), eq(ContratoDto.class))).thenReturn(contratoDto);

        List<ContratoDto> result = contratoService.getContratoByFechaCreacion(date);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(contratoDto, result.get(0));
        verify(contratoRepository, times(1)).findByFechaCreacion(date);
    }

    @Test
    void getContratoByFechaEntrada() throws ServiceException {
        when(contratoRepository.findByFechaEntrada(any(Date.class))).thenReturn(Arrays.asList(contrato));
        when(modelMapper.map(any(Contrato.class), eq(ContratoDto.class))).thenReturn(contratoDto);

        List<ContratoDto> result = contratoService.getContratoByFechaEntrada(date);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(contratoDto, result.get(0));
        verify(contratoRepository, times(1)).findByFechaEntrada(date);
    }

    @Test
    void getContratoByFechaSalida() throws ServiceException {
        when(contratoRepository.findByFechaSalida(any(Date.class))).thenReturn(Arrays.asList(contrato));
        when(modelMapper.map(any(Contrato.class), eq(ContratoDto.class))).thenReturn(contratoDto);

        List<ContratoDto> result = contratoService.getContratoByFechaSalida(date);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(contratoDto, result.get(0));
        verify(contratoRepository, times(1)).findByFechaSalida(date);
    }

    @Test
    void deleteContrato() throws ServiceException {
        doNothing().when(contratoRepository).deleteById(anyLong());

        contratoService.deleteContrato(1L);

        verify(contratoRepository, times(1)).deleteById(1L);
    }

    @Test
    void getContratoByNroContrato() throws ServiceException {
        when(contratoRepository.findById(anyLong())).thenReturn(Optional.of(contrato));
        when(modelMapper.map(any(Contrato.class), eq(ContratoDto.class))).thenReturn(contratoDto);

        ContratoDto result = contratoService.getContratoByNroContrato(1L);

        assertNotNull(result);
        assertEquals(contratoDto, result);
        verify(contratoRepository, times(1)).findById(1L);
    }


}
