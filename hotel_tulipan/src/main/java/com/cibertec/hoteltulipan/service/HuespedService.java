package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Huesped;

import java.util.List;

public interface HuespedService {
    List<Huesped> listarHuespedes();
    void guardarHuesped(Huesped huesped);
    Huesped obtenerHuespedPorId(Integer id);
    void eliminarHuesped(Integer id);
    List<Huesped> listarHuespedPorFiltro(String filtro);
}
