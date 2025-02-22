package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Habitacion;
import com.cibertec.hoteltulipan.repository.HabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements HabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Override
    public List<Habitacion> listarHabitaciones() {
        return habitacionRepository.findAll();
    }

    @Override
    public void guardarHabitacion(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion obtenerHabitacionPorId(Integer id) {
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada para el ID: " + id));
    }

    @Override
    public void eliminarHabitacion(Integer id) {
        if (habitacionRepository.existsById(id)) {
            habitacionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Habitación no encontrada para el ID: " + id);
        }
    }

    @Override
    public List<Habitacion> listarHabitacionesPorEstado(String estado) {
        return habitacionRepository.findAll();
    }
}
