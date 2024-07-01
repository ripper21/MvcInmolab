package es.inmolab.demo.service.empleado;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.dto.EmpleadoDto;
import es.inmolab.demo.entity.Empleado;
import es.inmolab.demo.repository.EmpleadoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<EmpleadoDto> getAllEmpleados() throws ServiceException {
		log.info("[getAllEmpleados]");
		List<EmpleadoDto> empleadosDTO;
		try {
			// Usa ModelMapper para convertir la lista de Empleado a EmpleadoDTO
			List<Empleado> empleados = empleadoRepository.findAll();
			empleadosDTO = empleados.stream().map(empleado -> modelMapper.map(empleado, EmpleadoDto.class))
					.collect(Collectors.toList());
		} catch (Exception e) {
			log.error("ERROR GENERAL DESDE EMPLEADO SERVICE", e);
			log.error("[No encuentra o no mapea EmpleadoDto]");
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}
		log.info("[empleados: " + empleadosDTO + "]");
		return empleadosDTO;
	}

	@Override
	public EmpleadoDto getEmpleadoById(Long id) throws ServiceException {
		log.info("[getEmpleadoById]");
		log.debug("[BUSCANDO EMPLEADO POR ID]: " + id);

		try {
			// Encuentra el empleado por ID y lanza una excepción si no se encuentra
			Empleado empleado = empleadoRepository.findById(id)
					.orElseThrow(() -> new ServiceException(ErrorCode.EMPLEADO_NO_ENCONTRADO));

			// Usa ModelMapper para convertir el objeto Empleado en EmpleadoDTO
			EmpleadoDto empleadoDTO = modelMapper.map(empleado, EmpleadoDto.class);
			return empleadoDTO;
		} catch (ServiceException se) {
			log.error("[SERVICIO EXCEPTION]", se);
			throw se; // Relanza la ServiceException si es lanzada
		} catch (Exception e) {
			log.error("[ERROR GENERAL]", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}
	}

	@Override
	public void saveEmpleado(Empleado empleado) throws ServiceException {
		log.info("[saveEmpleado]");
		log.info("[EMPLEADO GUARDADO]" + empleado.toString() + "]");
		try {
			empleadoRepository.save(empleado);
		} catch (Exception e) {
			log.error("[ERROR GENERAL]", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);

		}

	}

	@Override
	public void deleteEmpleado(Long id) throws ServiceException {
		log.info("[ELIMINAR EMPLEADO ]");
		log.debug("[EMPLEADO ELIMINADO POR id:" + id + "]");
		try {
			empleadoRepository.deleteById(id);
		} catch (Exception e) {
			log.error("[ERROR GENERAL]", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}

	}

	@Override
	public void upgradeEmpleado(Empleado empleado) throws ServiceException {
		log.info("[MODIFICAR EMPLEADO ]");
		log.debug("[MODIFICAR ELIMINADO :" + empleado.toString() + "]");
		try {
			empleadoRepository.save(empleado);
		} catch (Exception e) {
			log.error("[ERROR GENERAL]", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}

	}

	private EmpleadoDto map(Empleado empleadoBBDD) {
		EmpleadoDto empleado = new EmpleadoDto();
		empleado.setIdEmpleado(empleadoBBDD.getIdEmpleado());
		empleado.setNombre(empleadoBBDD.getNombre());
		empleado.setApellido(empleadoBBDD.getApellido());
		empleado.setTelefono(empleadoBBDD.getTelefono());
		empleado.setCorreo(empleadoBBDD.getCorreo());
		return empleado;
	}

}