package es.inmolab.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_departamento")
	    private Long idDepartamento;

	    private String nombre;

	    @OneToMany(mappedBy = "departamento")
	    private List<Empleado> empleados;

	    // Constructor, getters y setters

	    public Long getIdDepartamento() {
	        return idDepartamento;
	    }

	    public void setIdDepartamento(Long idDepartamento) {
	        this.idDepartamento = idDepartamento;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public List<Empleado> getEmpleados() {
	        return empleados;
	    }

	    public void setEmpleados(List<Empleado> empleados) {
	        this.empleados = empleados;
	    }

}
