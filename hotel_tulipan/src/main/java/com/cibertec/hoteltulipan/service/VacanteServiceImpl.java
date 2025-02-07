package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Vacante;
import com.cibertec.hoteltulipan.repository.VacanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VacanteServiceImpl implements VacanteService{
    private final VacanteRepository vacanteRepository;

    @Override
    public List<Vacante> listarVacantes() {return vacanteRepository.findAll();}


    @Override
    public void guardarVacante(Vacante vacante) {
        vacanteRepository.save(vacante);
    }

    @Override
    public Vacante obtenerVacantePorId(Integer id) {
        return vacanteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Vacante no encontrado para el id"+ id));
    }

    @Override
    public void eliminarVacante(Integer id) {
        if (vacanteRepository.existsById(id)) {
            vacanteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Vacante no encontrado para el id"+ id);
        }
    }
}
