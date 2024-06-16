package es.inmolab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.inmolab.demo.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
