package es.inmolab.demo.dto;

import java.util.Date;

import es.inmolab.demo.entity.TipoContrato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDto {

	private Long idContrato;
	private Date fechCreacion;
	private Date fechEntrada;
	private Date fechSalida;
	private Double precioNeto;
	private TipoContrato tipoContrato;
	private byte[] documento;
}