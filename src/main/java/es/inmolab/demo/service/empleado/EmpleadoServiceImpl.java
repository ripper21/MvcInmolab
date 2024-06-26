package es.inmolab.demo.service.empleado;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.inmolab.demo.entity.Empleado;
import es.inmolab.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        return empleadoOptional.orElse(null);
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}