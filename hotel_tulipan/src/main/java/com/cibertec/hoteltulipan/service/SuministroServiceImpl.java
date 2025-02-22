package com.cibertec.hoteltulipan.service;
import com.cibertec.hoteltulipan.model.Suministro;
import com.cibertec.hoteltulipan.repository.SuministroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SuministroServiceImpl implements SuministroService {

    private final SuministroRepository suministroRepository;

    @Override
    public List<Suministro> listarSuministros() {return suministroRepository.findAll();}


    @Override
    public void guardarSuministro(Suministro suministro) {
        suministroRepository.save(suministro);
    }

    @Override
    public Suministro obtenerSuministroPorId(Integer id) {
        return suministroRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Suministro no encontrado para el ID"+ id));
    }

    @Override
    public void eliminarSuministro(Integer id) {
        if (suministroRepository.existsById(id)) {
            suministroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Suministro no encontrado para el ID"+ id);
        }
    }

    @Override
    public List<Suministro> listarSuministroPorFiltro(String filtro) {
        return suministroRepository.findSuministroPorFiltro(filtro);
    }
}
