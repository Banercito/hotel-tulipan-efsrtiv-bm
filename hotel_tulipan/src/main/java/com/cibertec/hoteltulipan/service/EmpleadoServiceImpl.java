package com.cibertec.hoteltulipan.service;
import com.cibertec.hoteltulipan.model.Empleado;
import com.cibertec.hoteltulipan.repository.EmpleadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{
    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarEmpleados() {return empleadoRepository.findAll();}


    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empleado no encontrado para el id"+ id));
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empleado no encontrado para el id"+ id);
        }
    }

    @Override
    public List<Empleado> listarEmpleadoPorFiltro(String filtro) {
        return empleadoRepository.findEmpleadoPorFiltro(filtro);
    }

}
