package es.inmolab.demo.service.usuario;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.inmolab.demo.dto.login.Usuario;
import es.inmolab.demo.entity.UsuariosEntity;
import es.inmolab.demo.repository.UsuariosRepository;

@Service
public class UsuariosImpl implements UsuariosService {
    private static final Logger log = LoggerFactory.getLogger(UsuariosImpl.class);
    private final UsuariosRepository usuariosRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UsuariosImpl(UsuariosRepository usuariosRepository, BCryptPasswordEncoder passwordEncoder,
                        ModelMapper modelMapper) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public Usuario crearUsuario(Usuario body) {
        log.info("crearUsuario");
        log.debug("body: {}", body);
        try {
            UsuariosEntity nuevoUsuario = modelMapper.map(body, UsuariosEntity.class);
            nuevoUsuario.setPassword(passwordEncoder.encode(body.getPassword()));
            usuariosRepository.save(nuevoUsuario);
            return body;
        } catch (Exception e) {
            log.error("No se pudo ingresar el nuevo usuario ", e);
        }
        return null;
    }

    @Override
    public void guardar(Usuario registroDTO) {
        // Implementación o eliminación del método si no se usa
    }
}
