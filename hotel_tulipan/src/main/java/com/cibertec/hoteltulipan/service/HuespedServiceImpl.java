package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Huesped;
import com.cibertec.hoteltulipan.repository.HuespedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HuespedServiceImpl implements HuespedService {

    private final HuespedRepository huespedRepository;

    @Override
    public List<Huesped> listarHuespedes() {
        return huespedRepository.findAll();
    }

    @Override
    public void guardarHuesped(Huesped huesped) {
        huespedRepository.save(huesped);
    }

    @Override
    public Huesped obtenerHuespedPorId(Integer id) {
        return huespedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Huésped no encontrado para el id: " + id));
    }

    @Override
    public void eliminarHuesped(Integer id) {
        if(huespedRepository.existsById(id)){
            huespedRepository.deleteById(id);
        }else{
            throw new RuntimeException("Auto no encontrado para el id: " + id);
        }
    }

    @Override
    public List<Huesped> listarHuespedPorFiltro(String filtro) {
        return huespedRepository.findHuespedPorFiltro(filtro);
    }

}
