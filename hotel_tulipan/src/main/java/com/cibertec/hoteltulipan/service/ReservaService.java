package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> listarReservas();
    void guardarReserva(Reserva reserva);
    Reserva obtenerReservaPorId(Integer id);
    void eliminarReserva(Integer id);
    List<Reserva> listarReservasPorFiltro(String filtro);
}
