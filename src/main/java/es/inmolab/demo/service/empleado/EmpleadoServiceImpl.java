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
		log.info("[empleados:" + empleados + "]");
		try {
			empleados = empleadoRepository.findAll();
		} catch (Exception e) {
			log.error("ERROR GENERAL DESDE  EMPLEADO SERVICE", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}
		return empleados;
	}

	@Override
	public Empleado getEmpleadoById(Long id) throws ServiceException {
	    log.info("[getEmpleadoById]");
	    log.debug("[BUSCANDO EMPLEADO POR ID]: " + id);

	    Empleado empleado = null;
	    try {
	        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
	        if (!empleadoOptional.isPresent()) {
	            throw new ServiceException(ErrorCode.EMPLEADO_NO_ENCONTRADO);
	        }
	        empleado = empleadoOptional.get();
	    } catch (ServiceException se) {
	        log.error("[SERVICIO EXCEPTION]", se);
	        throw se;
	    } catch (Exception e) {
	        log.error("[ERROR GENERAL]", e);
	        throw new ServiceException(ErrorCode.ERROR_GENERAL);
	    }

	    return empleado;
	}


	@Override
	public void saveEmpleado(Empleado empleado)throws ServiceException  {
		log.info("[saveEmpleado]");
		log.info("[EMPLEADO GUARDADO]" +empleado.toString()+"]");
		try {
			 empleadoRepository.save(empleado);
		} catch ( Exception e) {
			log.error("[ERROR GENERAL]",e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
			
		}
		 
	}

	@Override
	public void deleteEmpleado(Long id) throws ServiceException   {
		log.info("[ELIMINAR EMPLEADO ]");
		log.debug("[EMPLEADO ELIMINADO POR id:"+id+"]");
		try {
			empleadoRepository.deleteById(id);
		}catch(Exception e) {
			log.error("[ERROR GENERAL]",e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}
		
	}
	@Override
	public void upgradeEmpleado(Empleado empleado) throws ServiceException   {
		log.info("[MODIFICAR EMPLEADO ]");
		log.debug("[MODIFICAR ELIMINADO :"+empleado.toString()+"]");
		try {
			empleadoRepository.save(empleado);
		}catch(Exception e) {
			log.error("[ERROR GENERAL]",e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}
		
	}


	
}