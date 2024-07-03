package es.inmolab.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.inmolab.demo.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	List<Contrato> findByCalle(String calle);
}

