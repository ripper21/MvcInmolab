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
@Table(name = "propiedades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Propiedades {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_propeidad")
	private Long idPropiedad;
	
	@Column(name = "fech_captacion")
	private Date FechaCaptacion;
	
	@Column(name = "cod_postal")
	private int codigoPostal;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "num_calle")
	private int numeroCalle;
	
	

}
