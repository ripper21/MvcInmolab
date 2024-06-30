package es.inmolab.demo.service.usuario;

import es.inmolab.demo.dto.login.Usuario;

public interface UsuariosService {
	
	Usuario crearUsuario(Usuario body);

	void guardar(Usuario registroDTO);

}
