package com.cibertec.hoteltulipan.service;
import com.cibertec.hoteltulipan.model.Cargo;
import com.cibertec.hoteltulipan.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CargoServiceImpl implements CargoService{
    private final CargoRepository cargoRepository;

    @Override
    public List<Cargo> listarCargos() {return cargoRepository.findAll();}

    @Override
    public void guardarCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    @Override
    public Cargo obtenerCargoPorId(Integer id) {
        return cargoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("cargo no encontrado para el id"+ id));
    }

    @Override
    public void eliminarCargo(Integer id) {
        if (cargoRepository.existsById(id)) {
            cargoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Proveedor no encontrado para el id"+ id);
        }
    }
}
