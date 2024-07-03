package es.inmolab.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.inmolab.demo.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    List<Contrato> findByFechaCreacion(Date fechaCreacion);
    List<Contrato> findByFechaEntrada(Date fechaEntrada);
    List<Contrato> findByFechaSalida(Date fechaSalida);
}
