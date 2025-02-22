package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Habitacion;
import java.util.List;

public interface HabitacionService {
    List<Habitacion> listarHabitaciones();
    void guardarHabitacion(Habitacion habitacion);
    Habitacion obtenerHabitacionPorId(Integer id);
    void eliminarHabitacion(Integer id);
    List<Habitacion> listarHabitacionesPorEstado(String estado);
}
