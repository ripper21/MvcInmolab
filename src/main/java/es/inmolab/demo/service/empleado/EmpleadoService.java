package es.inmolab.demo.service.empleado;

import java.util.List;

import es.inmolab.demo.entity.Empleado;

public interface EmpleadoService {

	List<Empleado> getAllEmpleados();

	Empleado getEmpleadoById(Long id);

	void saveEmpleado(Empleado empleado);

	void deleteEmpleado(Long id);
}
