package es.inmolab.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.inmolab.demo.dto.Usuario;
import es.inmolab.demo.service.UsuariosService;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
	
	private final UsuariosService usuarioService;

	public RegistroUsuarioControlador(UsuariosService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@ModelAttribute("usuario")
	public Usuario retornaNuevoUsarioRegistroDTO() {
		return new Usuario();
		
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario( @ModelAttribute("usuario") Usuario registroDTO) {
		usuarioService.guardar(registroDTO);
		return "redirect:/registro?exito";
		
	}
	
}
