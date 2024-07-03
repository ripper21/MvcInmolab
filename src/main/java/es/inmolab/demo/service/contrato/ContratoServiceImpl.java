package es.inmolab.demo.service.contrato;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.dto.ContratoDto;
import es.inmolab.demo.entity.Contrato;
import es.inmolab.demo.repository.ContratoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContratoServiceImpl implements ContratoService {

	private final ContratoRepository contratoRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public ContratoServiceImpl(ContratoRepository contratoRepository, ModelMapper modelMapper) {
		this.contratoRepository = contratoRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ContratoDto> getAllContrato() throws ServiceException {
		log.info("[getAllContrato]");
		try {
			List<Contrato> contratos = contratoRepository.findAll();
			return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoDto.class))
					.collect(Collectors.toList());
		} catch (DataAccessException e) {
			log.error("Error al recuperar todos los contratos", e);
			throw new ServiceException("Error al recuperar todos los contratos", ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}

	@Override
	public List<ContratoDto> getContratoByFechaCreacion(Date fechCreacion) throws ServiceException {
		log.info("[getContratoByFechaCreacion]");
		try {
			List<Contrato> contratos = contratoRepository.findByFechaCreacion(fechCreacion);
			return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoDto.class))
					.collect(Collectors.toList());
		} catch (DataAccessException e) {
			log.error("Error al recuperar contratos por fecha de creación", e);
			throw new ServiceException("Error al recuperar contratos por fecha de creación",
					ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}

	@Override
	public List<ContratoDto> getContratoByFechaEntrada(Date fechEntrada) throws ServiceException {
		log.info("[getContratoByFechaEntrada]");
		try {
			List<Contrato> contratos = contratoRepository.findByFechaEntrada(fechEntrada);
			return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoDto.class))
					.collect(Collectors.toList());
		} catch (DataAccessException e) {
			log.error("Error al recuperar contratos por fecha de entrada", e);
			throw new ServiceException("Error al recuperar contratos por fecha de entrada",
					ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}

	@Override
	public List<ContratoDto> getContratoByFechaSalida(Date fechSalida) throws ServiceException {
		log.info("[getContratoByFechaSalida]");
		try {
			List<Contrato> contratos = contratoRepository.findByFechaSalida(fechSalida);
			return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoDto.class))
					.collect(Collectors.toList());
		} catch (DataAccessException e) {
			log.error("Error al recuperar contratos por fecha de salida", e);
			throw new ServiceException("Error al recuperar contratos por fecha de salida",
					ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}

	@Override
	public void deleteContrato(Long id) throws ServiceException {
		log.info("[deleteContrato]");
		log.debug("[ELIMINAR CONTRATO POR id: " + id + "]");
		try {
			contratoRepository.deleteById(id);
		} catch (DataAccessException e) {
			log.error("Error al eliminar contrato", e);
			throw new ServiceException("Error al eliminar contrato", ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}

	@Override
	public void upgradeContrato(Contrato contrato) throws ServiceException {
		log.info("[upgradeContrato]");
		log.debug("[MODIFICAR CONTRATO: " + contrato.toString() + "]");
		try {
			contratoRepository.save(contrato);
		} catch (DataAccessException e) {
			log.error("Error al modificar contrato", e);
			throw new ServiceException("Error al modificar contrato", ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}

	@Override
	public ContratoDto getContratoByNroContrato(long id) throws ServiceException {
		log.info("[getContratoByNroContrato]");
		log.debug("[BUSCANDO CONTRATO POR ID]: " + id);
		try {
			Contrato contrato = contratoRepository.findById(id).orElseThrow(
					() -> new ServiceException("Contrato no encontrado", ErrorCode.PROPIEDAD_NO_ENCONTRADA));
			return modelMapper.map(contrato, ContratoDto.class);
		} catch (ServiceException se) {
			log.error("Servicio exception", se);
			throw se;
		} catch (DataAccessException e) {
			log.error("Error general", e);
			throw new ServiceException("Error general", ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}

	@Override
	public void saveContrato(Contrato contrato) throws ServiceException {
		log.info("[saveContrato]");
		log.debug("[CONTRATO GUARDADO: " + contrato.toString() + "]");
		try {
			contratoRepository.save(contrato);
		} catch (DataAccessException e) {
			log.error("Error al guardar contrato", e);
			throw new ServiceException("Error al guardar contrato", ErrorCode.PROPIEDAD_ERROR_GENERAL);
		}
	}
}
