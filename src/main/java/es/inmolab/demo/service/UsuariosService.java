package es.inmolab.demo.service;

import es.inmolab.demo.dto.Usuario;

public interface UsuariosService {
	
	Usuario crearUsuario(Usuario body);

	void guardar(Usuario registroDTO);

}
