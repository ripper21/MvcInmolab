package es.inmolab.demo.dto.login;
import lombok.Data;

@Data
public class Usuario {
	
	private String username;

	private String password;

	private Integer enabled;

}
