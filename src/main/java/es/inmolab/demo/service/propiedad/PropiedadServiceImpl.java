package es.inmolab.demo.service.propiedad;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import es.inmolab.demo.common.exception.ErrorCode;
import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Propiedad;
import es.inmolab.demo.repository.PropiedadRepository;

@Service
public  class PropiedadServiceImpl implements PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    @Override
    public List<Propiedad> getAllPropiedades() throws ServiceException {
        try {
            return propiedadRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException(ErrorCode.PROPIEDAD_ERROR_GENERAL);
        }
    }

    @Override
    public List<Propiedad> getPropiedadByCalle(String calle) throws ServiceException {
        List<Propiedad> propiedades = propiedadRepository.findByCalle(calle);
		return propiedades; 
    }


    @Override
    public void savePropiedad(Propiedad propiedad) throws ServiceException {
        try {
            propiedadRepository.save(propiedad);
        } catch (DataAccessException e) {
            throw new ServiceException(ErrorCode.PROPIEDAD_SAVE_ERROR);
        }
    }

    @Override
    public void deletePropiedad(Long id) throws ServiceException {
        try {
            if (!propiedadRepository.existsById(id)) {
                throw new ServiceException( ErrorCode.PROPIEDAD_NOT_FOUND);
            }
            propiedadRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServiceException( ErrorCode.PROPIEDAD_ERROR_GENERAL);
        }
    }

    @Override
    public void upgradePropiedad(Propiedad propiedad) throws ServiceException {
        try {
            propiedadRepository.save(propiedad);
        } catch (DataAccessException e) {
            throw new ServiceException( ErrorCode.PROPIEDAD_UPDATE_ERROR);
        }
    }

    @Override
    public Propiedad getPropiedadById(long id) throws ServiceException {
        try {
            Optional<Propiedad> propiedad = propiedadRepository.findById(id);
            if (!propiedad.isPresent()) {
                throw new ServiceException( ErrorCode.PROPIEDAD_NOT_FOUND);
            }
            return propiedad.get();
        } catch (DataAccessException e) {
            throw new ServiceException( ErrorCode.PROPIEDAD_ERROR_GENERAL);
        }
    }




}
