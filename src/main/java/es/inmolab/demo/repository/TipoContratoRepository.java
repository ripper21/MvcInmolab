package es.inmolab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.inmolab.demo.entity.TipoContrato;

@Repository
public interface TipoContratoRepository extends JpaRepository<TipoContrato, Long> {
}
