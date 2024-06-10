package es.inmolab.demo.service;

import es.inmolab.demo.dto.Usuario;

public interface UsuariosService {
	
	public Usuario crearUsuario(Usuario body);

	public void guardar(Usuario registroDTO);

}
