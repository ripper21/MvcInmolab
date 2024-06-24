package es.inmolab.demo.entity;

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
@Table(name = "tipocontrato")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoContrato {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "TIPO_CONTRATO_ID")
	    private Long tipoContratoId;

	    @Column(name = "NOMBRE", nullable = false, length = 150)
	    private String nombre;

	    // Getters and Setters
	}


