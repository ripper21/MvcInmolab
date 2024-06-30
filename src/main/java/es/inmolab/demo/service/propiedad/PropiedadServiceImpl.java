package es.inmolab.demo.service.propiedad;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Propiedad;
import es.inmolab.demo.repository.PropiedadRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PropiedadServiceImpl implements PropiedadService {

    private final PropiedadRepository propiedadRepository;

    public PropiedadServiceImpl(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    @Override
    public List<Propiedad> getAllPropiedades() throws ServiceException {
		log.info("[getAllPropiedades]");
        try {
            return propiedadRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("Error al recuperar todas las propiedades", ErrorCode.PROPIEDAD_ERROR_GENERAL);
        }
    }

    @Override
    public List<Propiedad> getPropiedadByCalle(String calle) throws ServiceException {
    	log.info("[getPropiedadByCalle]");
        try {
        	log.info("[Busco lista de  propieda por calle :" + calle + "]");
            return propiedadRepository.findByCalle(calle);
        } catch (DataAccessException e) {
            throw new ServiceException("Error al buscar propiedades en la calle: " + calle, ErrorCode.PROPIEDAD_ERROR_GENERAL);
        }
    }

    @Override
    public void savePropiedad(Propiedad propiedad) throws ServiceException {
    	log.info("[savePropiedad]");    	
        try {
            propiedadRepository.save(propiedad);
            log.info("[propiedad:" + propiedad + "]");
        } catch (DataAccessException e) {
            throw new ServiceException("Error al guardar la propiedad", ErrorCode.PROPIEDAD_SAVE_ERROR);
        }
    }

    @Override
    public void deletePropiedad(Long id) throws ServiceException {
    	log.info("[deletePropiedad]");   
    	log.info("[Elimina propiedad por ID :" + id + "]");
        try {
            if (!propiedadRepository.existsById(id)) {
                throw new ServiceException("Propiedad no encontrada para el ID: " + id, ErrorCode.PROPIEDAD_NOT_FOUND);
            }
            propiedadRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("Error al eliminar la propiedad con ID: " + id, ErrorCode.PROPIEDAD_ERROR_GENERAL);
        }
    }

    @Override
    public void upgradePropiedad(Propiedad propiedad) throws ServiceException {
    	log.info("[upgradePropiedad]");   
        try {
            propiedadRepository.save(propiedad);
            log.info("[propiedad:" + propiedad + "]");
        } catch (DataAccessException e) {
            throw new ServiceException("Error al actualizar la propiedad", ErrorCode.PROPIEDAD_UPDATE_ERROR);
        }
    }

    @Override
    public Propiedad getPropiedadById(long id) throws ServiceException {
    	log.info("[getPropiedadById]");   
        Optional<Propiedad> propiedad = propiedadRepository.findById(id);
        log.info("[propiedad:" + propiedad + "]");
        return propiedad.orElseThrow(() -> new ServiceException("Propiedad no encontrada para el ID: " + id, ErrorCode.PROPIEDAD_NOT_FOUND));
    }
}
