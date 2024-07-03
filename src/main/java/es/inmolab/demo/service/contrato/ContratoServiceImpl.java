package es.inmolab.demo.service.contrato;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Contrato;
import es.inmolab.demo.service.propiedad.PropiedadServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContratoServiceImpl implements ContratoService {
	
	
	private final 

	@Override
	public List<ContratoDto> getAllContrato() throws ServiceException {
		
		return null;
	}

	@Override
	public List<Contrato> getContratoByFechaCreacion(Date fechEntrada) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContrato(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upgradeContrato(Contrato contrato) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contrato getContratoByNroContrato(long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveContrato(Contrato contrato) throws ServiceException {
		// TODO Auto-generated method stub
		
	}
	

}
