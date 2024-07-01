package es.inmolab.demo.service.usuario;

import es.inmolab.demo.dto.UsuarioDto;

public interface UsuariosService {
	
	UsuarioDto crearUsuario(UsuarioDto body);

	void guardar(UsuarioDto registroDTO);

}
