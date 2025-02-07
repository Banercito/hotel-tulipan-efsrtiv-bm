package com.cibertec.hoteltulipan.service;
import com.cibertec.hoteltulipan.model.Cargo;

import java.util.List;
public interface CargoService {
    List<Cargo> listarCargos();
    void guardarCargo(Cargo cargo);
    Cargo obtenerCargoPorId(Integer id);
    void eliminarCargo(Integer id);
}
