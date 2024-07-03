package es.inmolab.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto {

	private Long idEmpleado;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;
    
    
    
}

