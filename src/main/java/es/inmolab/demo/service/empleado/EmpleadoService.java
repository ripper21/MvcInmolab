package es.inmolab.demo.service.empleado;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import es.inmolab.demo.entity.Empleado;


public interface EmpleadoService {

	List<Empleado> getAllEmpleados()throws ServiceException;

	Empleado getEmpleadoById(Long id)throws ServiceException;

	void saveEmpleado(Empleado empleado)throws ServiceException;

	void deleteEmpleado(Long id)throws ServiceException;

	void upgradeEmpleado(Empleado empleado) throws ServiceException;
}
