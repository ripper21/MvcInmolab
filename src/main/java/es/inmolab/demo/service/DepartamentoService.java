package es.inmolab.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.inmolab.demo.entity.Departamento;
import es.inmolab.demo.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

}
