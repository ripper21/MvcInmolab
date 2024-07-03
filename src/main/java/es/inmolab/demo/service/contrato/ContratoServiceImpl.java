package es.inmolab.demo.service.contrato;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Contrato;
import es.inmolab.demo.repository.ContratoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContratoServiceImpl implements ContratoService {
	
	
	private final ContratoRepository contratoRepository ;
    public ContratoServiceImpl(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }
	
	@Override
	public List<Contrato> getAllContrato() throws ServiceException {
		log.info("[getAllContrato]");
        try {
            return contratoRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("Error al recuperar todos los contratos", ErrorCode.PROPIEDAD_ERROR_GENERAL);
        }
	}

	@Override
	public List<Contrato> getContratoByFechaCreacion(Date fechCreacion) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> getContratoByFechaEntrada(Date fechEntrada) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> getContratoByFechaSalida(Date fechSalida) throws ServiceException {
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
