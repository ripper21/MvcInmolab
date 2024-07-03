package es.inmolab.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.inmolab.demo.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	@Query("SELECT c FROM Contrato c WHERE c.fechCreacion = :fechCreacion")
	List<Contrato> findByFechaCreacion(@Param("fechCreacion") Date fechCreacion);

	@Query("SELECT c FROM Contrato c WHERE c.fechEntrada = :fechEntrada")
	List<Contrato> findByFechaEntrada(@Param("fechEntrada") Date fechEntrada);

	@Query("SELECT c FROM Contrato c WHERE c.fechSalida = :fechSalida")
	List<Contrato> findByFechaSalida(@Param("fechSalida") Date fechSalida);
}
