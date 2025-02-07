package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Vacante;

import java.util.List;

public interface VacanteService {
    List<Vacante> listarVacantes();
    void guardarVacante(Vacante vacante);
    Vacante obtenerVacantePorId(Integer id);
    void eliminarVacante(Integer id);
}
