package es.inmolab.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.inmolab.demo.dto.UsuarioDto;
import es.inmolab.demo.entity.UsuariosEntity;
import es.inmolab.demo.repository.UsuariosRepository;
import es.inmolab.demo.service.usuario.UsuariosImpl;

@ExtendWith(MockitoExtension.class)
public class UsuariosImplTest {

    @Mock
    private UsuariosRepository usuariosRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UsuariosImpl usuariosService;

    private UsuarioDto usuarioDto;
    private UsuariosEntity usuariosEntity;

    @BeforeEach
    void setUp() {
        usuarioDto = new UsuarioDto();
        usuarioDto.setUsername("testuser");
        usuarioDto.setPassword("password");

        usuariosEntity = new UsuariosEntity();
        usuariosEntity.setUsername("testuser");
        usuariosEntity.setPassword("encodedPassword");
    }

    @Test
    void crearUsuario() {
        when(modelMapper.map(any(UsuarioDto.class), eq(UsuariosEntity.class))).thenReturn(usuariosEntity);
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(usuariosRepository.save(any(UsuariosEntity.class))).thenReturn(usuariosEntity);

        UsuarioDto result = usuariosService.crearUsuario(usuarioDto);

        assertNotNull(result);
        assertEquals(usuarioDto.getUsername(), result.getUsername());
        verify(modelMapper, times(1)).map(usuarioDto, UsuariosEntity.class);
        verify(passwordEncoder, times(1)).encode(usuarioDto.getPassword());
        verify(usuariosRepository, times(1)).save(usuariosEntity);
    }
}
