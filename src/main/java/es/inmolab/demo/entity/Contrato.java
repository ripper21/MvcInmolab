package es.inmolab.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contrato")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private Long idContrato;
    
    @Column(name = "fech_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechCreacion;

    @Column(name = "fech_entrada", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechEntrada;

    @Column(name = "fech_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechSalida;

    @Column(name = "precio_neto", nullable = false)
    private Double precioNeto;

    @ManyToOne
    @JoinColumn(name = "id_tipo_operacion", referencedColumnName = "id_tipo_contrato", nullable = false)
    private TipoContrato tipoContrato;

    @Lob
    @Column(name = "documento")
    private byte[] documento;  // Campo para almacenar documentos como PDF o DOCX
}
