package es.inmolab.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "propiedad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propiedad")
    private Long idPropiedad;

    @Column(name = "fech_captacion")
    private Date fechCaptacion;

    @Column(name = "cod_postal")
    private String codPostal;

    @Column(name = "calle")
    private String calle;

    @Column(name = "num_calle")
    private String numCalle;

    @ManyToMany
    @JoinTable(
        name = "propiedades_caracteristicas",
        joinColumns = @JoinColumn(name = "id_propiedad"),
        inverseJoinColumns = @JoinColumn(name = "id_caracteristica")
    )
    private Set<CaracteristicaPropiedad> caracteristicas = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleadoCaptador;
}
