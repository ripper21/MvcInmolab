package es.inmolab.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.inmolab.demo.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.tipoCliente.descripcion = :tipoCliente")
    List<Cliente> encontrarClientePorTipo(@Param("tipoCliente") String tipoCliente);
}
