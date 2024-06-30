package es.inmolab.demo.dto.propiedad;


import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PropiedadDTO {

    private Long idPropiedad;
    private Date fechCaptacion;
    private String codPostal;
    private String calle;
    private String numCalle;
    private Set<String> caracteristicas; 

}
