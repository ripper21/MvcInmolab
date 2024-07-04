package es.inmolab.demo.service.contrato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.TipoContrato;
import es.inmolab.demo.repository.TipoContratoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TipoContratoServiceImpl implements TipoContratoService {

    private final TipoContratoRepository tipoContratoRepository;

    @Autowired
    public TipoContratoServiceImpl(TipoContratoRepository tipoContratoRepository) {
        this.tipoContratoRepository = tipoContratoRepository;
    }

    @Override
    public List<TipoContrato> getAllTipoContrato() throws ServiceException {
        log.info("[getAllTipoContrato]");
        try {
            return tipoContratoRepository.findAll();
        } catch (DataAccessException e) {
            log.error("Error al recuperar todos los tipos de contrato", e);
            throw new ServiceException("Error al recuperar todos los tipos de contrato", ErrorCode.ERROR_GENERAL);
        }
    }
}
