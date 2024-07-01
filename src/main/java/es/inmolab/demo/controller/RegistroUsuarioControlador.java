package es.inmolab.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.inmolab.demo.dto.UsuarioDto;
import es.inmolab.demo.service.usuario.UsuariosService;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
	
	private final UsuariosService usuarioService;

	public RegistroUsuarioControlador(UsuariosService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@ModelAttribute("usuario")
	public UsuarioDto retornaNuevoUsarioRegistroDTO() {
		return new UsuarioDto();
		
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario( @ModelAttribute("usuario") UsuarioDto registroDTO) {
		usuarioService.guardar(registroDTO);
		return "redirect:/registro?exito";
		
	}
	
}
