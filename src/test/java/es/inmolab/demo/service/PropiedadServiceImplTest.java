package es.inmolab.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Propiedad;
import es.inmolab.demo.repository.PropiedadRepository;
import es.inmolab.demo.service.propiedad.PropiedadServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PropiedadServiceImplTest {

    @Mock
    private PropiedadRepository propiedadRepository;

    @InjectMocks
    private PropiedadServiceImpl propiedadService;

    private Propiedad propiedad;

    @BeforeEach
    void setUp() {
        propiedad = new Propiedad();
        propiedad.setIdPropiedad(1L);
        propiedad.setCalle("Calle Falsa 123");
    }

    @Test
    void getAllPropiedades() throws ServiceException {
        when(propiedadRepository.findAll()).thenReturn(Arrays.asList(propiedad));

        List<Propiedad> result = propiedadService.getAllPropiedades();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(propiedad, result.get(0));
        verify(propiedadRepository, times(1)).findAll();
    }

    @Test
    void getPropiedadByCalle() throws ServiceException {
        when(propiedadRepository.findByCalle(anyString())).thenReturn(Arrays.asList(propiedad));

        List<Propiedad> result = propiedadService.getPropiedadByCalle("Calle Falsa 123");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(propiedad, result.get(0));
        verify(propiedadRepository, times(1)).findByCalle("Calle Falsa 123");
    }

    @Test
    void savePropiedad() throws ServiceException {
        doNothing().when(propiedadRepository).save(any(Propiedad.class));

        propiedadService.savePropiedad(propiedad);

        verify(propiedadRepository, times(1)).save(propiedad);
    }

    @Test
    void deletePropiedad() throws ServiceException {
        when(propiedadRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(propiedadRepository).deleteById(anyLong());

        propiedadService.deletePropiedad(1L);

        verify(propiedadRepository, times(1)).deleteById(1L);
    }

    @Test
    void deletePropiedad_NotFound() {
        when(propiedadRepository.existsById(anyLong())).thenReturn(false);

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            propiedadService.deletePropiedad(1L);
        });

        assertEquals(ErrorCode.PROPIEDAD_NOT_FOUND, exception.getErrorCode());
        verify(propiedadRepository, never()).deleteById(anyLong());
    }

    @Test
    void upgradePropiedad() throws ServiceException {
        doNothing().when(propiedadRepository).save(any(Propiedad.class));

        propiedadService.upgradePropiedad(propiedad);

        verify(propiedadRepository, times(1)).save(propiedad);
    }

    @Test
    void getPropiedadById() throws ServiceException {
        when(propiedadRepository.findById(anyLong())).thenReturn(Optional.of(propiedad));

        Propiedad result = propiedadService.getPropiedadById(1L);

        assertNotNull(result);
        assertEquals(propiedad, result);
        verify(propiedadRepository, times(1)).findById(1L);
    }

    @Test
    void getPropiedadById_NotFound() {
        when(propiedadRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            propiedadService.getPropiedadById(1L);
        });

        assertEquals(ErrorCode.PROPIEDAD_NOT_FOUND, exception.getErrorCode());
        verify(propiedadRepository, times(1)).findById(1L);
    }
}
