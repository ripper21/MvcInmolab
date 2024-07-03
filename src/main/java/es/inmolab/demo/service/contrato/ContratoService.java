package es.inmolab.demo.service.contrato;

import java.util.Date;
import java.util.List;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Contrato;

public interface ContratoService {

	List<Contrato> getAllContrato() throws ServiceException;

	List<Contrato> getContratoByFechaCreacion(Date fechEntrada) throws ServiceException;

	void deleteContrato(Long id) throws ServiceException;

	void upgradeContrato(Contrato contrato) throws ServiceException;

	Contrato getContratoByNroContrato(long id) throws ServiceException;

	void saveContrato(Contrato contrato) throws ServiceException;

}
