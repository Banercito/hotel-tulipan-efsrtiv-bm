package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Postulante;

import java.util.List;

public interface PostulanteService {
    List<Postulante> listarPostulantes();
    void guardarPostulante(Postulante empleado);
    Postulante obtenerPostulantePorId(Integer id);
    void eliminarPostulante(Integer id);
}
