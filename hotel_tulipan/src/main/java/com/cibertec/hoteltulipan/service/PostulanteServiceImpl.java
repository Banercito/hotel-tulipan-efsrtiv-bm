package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Postulante;
import com.cibertec.hoteltulipan.repository.PostulanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulanteServiceImpl implements PostulanteService{
    private final PostulanteRepository postulanteRepository;

    @Override
    public List<Postulante> listarPostulantes() {return postulanteRepository.findAll();}


    @Override
    public void guardarPostulante(Postulante postulante) {
        postulanteRepository.save(postulante);
    }

    @Override
    public Postulante obtenerPostulantePorId(Integer id) {
        return postulanteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Postulante no encontrado para el id"+ id));
    }

    @Override
    public void eliminarPostulante(Integer id) {
        if (postulanteRepository.existsById(id)) {
            postulanteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Postulante no encontrado para el id"+ id);
        }
    }
}
