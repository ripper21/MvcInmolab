package es.inmolab.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

import es.inmolab.demo.dto.EmpleadoDto;
import es.inmolab.demo.service.empleado.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class EmpleadosControllerTest {

    @Mock
    private EmpleadoService empleadoService;

    @Mock
    private MessageSource messageSource;

    @Mock
    private Model model;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private EmpleadosController empleadosController;

    private EmpleadoDto empleadoDto;
    private List<EmpleadoDto> empleados;

    @BeforeEach
    void setUp() {
        empleadoDto = new EmpleadoDto();
        empleadoDto.setIdEmpleado(1L);
        empleadoDto.setNombre("John");
        empleadoDto.setApellido("Doe");
        empleadoDto.setTelefono(123456789L);
        empleadoDto.setCorreo("john.doe@example.com");
        empleadoDto.setFechNac(Date.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));

        empleados = Arrays.asList(empleadoDto);

        when(empleadoService.getAllEmpleados()).thenReturn(empleados);
        when(request.getLocale()).thenReturn(Locale.ENGLISH);
        when(messageSource.getMessage(anyString(), any(), eq(Locale.ENGLISH))).thenReturn("Month");
    }

    @Test
    void listarEmpleados() {
        String viewName = empleadosController.listarEmpleados(model, request);

        assertEquals("empleadosList", viewName);

        verify(empleadoService, times(1)).getAllEmpleados();
        verify(model, times(1)).addAttribute("empleados", empleados);

        List<Integer> edades = empleados.stream()
                .map(e -> Period.between(e.getFechNac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears())
                .collect(Collectors.toList());
        verify(model, times(1)).addAttribute("edades", edades);

        List<String> nombres = empleados.stream()
                .map(EmpleadoDto::getNombre)
                .collect(Collectors.toList());
        verify(model, times(1)).addAttribute("nombres", nombres);

        List<String> months = Arrays.asList(
                "Month", "Month", "Month", "Month", "Month", "Month",
                "Month", "Month", "Month", "Month", "Month", "Month"
        );
        verify(model, times(1)).addAttribute("months", months);
    }

    @Test
    void miMetodoGet() {
        String viewName = empleadosController.miMetodoGet();
        assertEquals("departamentos", viewName);
    }

    @Test
    void miMetodoPost() {
        String viewName = empleadosController.miMetodoPost();
        assertEquals("departamentos", viewName);
    }
}
