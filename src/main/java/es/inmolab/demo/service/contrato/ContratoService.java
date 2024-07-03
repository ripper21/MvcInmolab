package es.inmolab.demo.service.contrato;

import java.util.Date;
import java.util.List;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.dto.ContratoDto;
import es.inmolab.demo.entity.Contrato;

public interface ContratoService {

	List<ContratoDto> getAllContrato() throws ServiceException;

	List<ContratoDto> getContratoByFechaCreacion(Date fechCreacion) throws ServiceException;

	List<ContratoDto> getContratoByFechaEntrada(Date fechEntrada) throws ServiceException;

	List<ContratoDto> getContratoByFechaSalida(Date fechSalida) throws ServiceException;

	void deleteContrato(Long id) throws ServiceException;

	void upgradeContrato(Contrato contrato) throws ServiceException;

	ContratoDto getContratoByNroContrato(long id) throws ServiceException;

	void saveContrato(Contrato contrato) throws ServiceException;

}
