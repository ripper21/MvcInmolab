package es.inmolab.demo.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "fech_nac")
	private Date FechaNacimiento;
	
	@Column(name = "nif")
	private String nif;
	
	@Column(name = "tipo_cliente")
	private int tipoCliente;

	
	
	
	

}
