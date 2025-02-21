package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Suministro;

import java.util.List;

public interface SuministroService {

    List<Suministro> listarSuministros();
    void guardarSuministro(Suministro suministro);
    Suministro obtenerSuministroPorId(Integer id);
    void eliminarSuministro(Integer id);
    List<Suministro> listarSuministroPorFiltro(String filtro);
}


