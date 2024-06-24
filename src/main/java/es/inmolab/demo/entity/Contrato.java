package es.inmolab.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "contrato")
@Data
@AllArgsConstructor
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contratoId;


    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;


    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;

    @Column(name = "PRECIO_NETO", nullable = false)
    private Double precioNeto;
    
    @ManyToOne
    @JoinColumn(name = "TIPO_CONTRATO_ID", nullable = false)
    private TipoContrato tipoContrato;

    public Contrato() {
        super();
    }

    // Getters and Setters
}
