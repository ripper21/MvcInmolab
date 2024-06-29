package es.inmolab.demo.service.propiedad;

import java.util.List;

import es.inmolab.demo.common.exception.ServiceException;
import es.inmolab.demo.entity.Propiedad;

public interface PropiedadService {

    List<Propiedad> getAllPropiedades() throws ServiceException;

    List<Propiedad> getPropiedadByCalle(String calle) throws ServiceException;

    void deletePropiedad(Long id) throws ServiceException;

    void upgradePropiedad(Propiedad propiedad) throws ServiceException;

	Propiedad getPropiedadById(long id) throws ServiceException;


	void savePropiedad(Propiedad propiedad) throws ServiceException ;

	
}
