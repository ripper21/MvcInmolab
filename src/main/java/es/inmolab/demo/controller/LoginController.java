package es.inmolab.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String miMetodo() {
		return "login";
	}
	
	// Login form with error
	  @GetMapping("/loginError")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }
	  
	  @GetMapping("/accessDenied")
		public String accessDenied() {
			return "accessDenied";
	  }
	  
	  @GetMapping("/logout")
		public String logout() {
			return "login";
	  }
}
