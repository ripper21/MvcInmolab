package es.inmolab.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.inmolab.demo.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    @Query("SELECT c FROM Contrato c WHERE c.fechaCreacion = :fechaCreacion")
    List<Contrato> findByFechaCreacion(@Param("fechaCreacion") Date fechaCreacion);

    @Query("SELECT c FROM Contrato c WHERE c.fechaEntrada = :fechaEntrada")
    List<Contrato> findByFechaEntrada(@Param("fechaEntrada") Date fechaEntrada);

    @Query("SELECT c FROM Contrato c WHERE c.fechaSalida = :fechaSalida")
    List<Contrato> findByFechaSalida(@Param("fechaSalida") Date fechaSalida);
}

