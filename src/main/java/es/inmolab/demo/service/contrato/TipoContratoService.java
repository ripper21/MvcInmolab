package es.inmolab.demo.service.contrato;

import java.util.List;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.TipoContrato;

public interface TipoContratoService {
    List<TipoContrato> getAllTipoContrato() throws ServiceException;
}
