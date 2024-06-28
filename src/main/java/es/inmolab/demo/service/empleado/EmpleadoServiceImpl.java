package es.inmolab.demo.service.empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.entity.Empleado;
import es.inmolab.demo.repository.EmpleadoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> getAllEmpleados() throws ServiceException {
		log.info("[getAllEmpleados]");
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			empleados = empleadoRepository.findAll();
		} catch (Exception e) {
			log.error("ERROR GENERAL DESDE EMPLIMENTACION EMPLEADO SERVICE", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}
		return empleados;
	}

	@Override
	public Empleado getEmpleadoById(Long id) throws ServiceException {
		Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
		log.info("[getEmpleadoById]");
		log.debug("[ID DE EMPLEADO]:" + id + "]");
		Empleado empleado = null;
		try {
			Optional<Empleado> empleadoDummy = empleadoRepository.findById(id);
			if (!empleadoDummy.isPresent())
				throw new ServiceException(ErrorCode.NO_FOUND_CASA);
			empleado = empleadoDummy.get();
		} catch (ServiceException se) {
			log.error("[SERVICIO EXCEPTION]", se);
			throw se;
			// TODO: handle exception
		} catch (Exception e) {
			log.error("[ERROR GENERAL]", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
			// TODO: handle exception
		}

		return empleado;
	}

	@Override
	public void saveEmpleado(Empleado empleado)throws ServiceException  {
		log.info("[saveEmpleado]");
		log.info("[EMPLEADO]" +empleado.toString()+"]");
		try {
			empleadoRepository.save(empleado);
		} catch ( Exception e) {
			log.error("[ERROR GENERAL]",e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
			// TODO: handle exception
		}
		empleadoRepository.save(empleado);
	}

	@Override
	public void deleteEmpleado(Long id) {
		empleadoRepository.deleteById(id);
	}
}