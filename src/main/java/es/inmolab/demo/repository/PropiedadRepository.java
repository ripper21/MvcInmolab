package es.inmolab.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.inmolab.demo.entity.Propiedad;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {

	List<Propiedad> findByCalle(String calle);
}

