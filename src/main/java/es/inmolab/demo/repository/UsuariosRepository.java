package es.inmolab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.inmolab.demo.entity.UsuariosEntity;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {
    UsuariosEntity findByUsername(String username);
}
