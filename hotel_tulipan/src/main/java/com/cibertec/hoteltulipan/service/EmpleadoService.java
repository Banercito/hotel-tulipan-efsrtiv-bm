package com.cibertec.hoteltulipan.service;


import com.cibertec.hoteltulipan.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> listarEmpleados();
    void guardarEmpleado(Empleado empleado);
    Empleado obtenerEmpleadoPorId(Integer id);
    void eliminarEmpleado(Integer id);
    List<Empleado> listarEmpleadoPorFiltro(String filtro);
    void actualizarEmpleado(Empleado empleado);
}
