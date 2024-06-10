package es.inmolab.demo.dto;
import lombok.Data;

@Data
public class Usuario {
	
	private String username;

	private String password;

	private Integer enabled;

}
