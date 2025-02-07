package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.SolicitudDeServicios;
import com.cibertec.hoteltulipan.repository.SolicitudDeServiciosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolicitudDeServiciosServiceImpl implements SolicitudDeServiciosService {
    private final SolicitudDeServiciosRepository solicitudDeServiciosRepository;


    @Override
    public List<SolicitudDeServicios> listarSolicitudDeServicios() {return solicitudDeServiciosRepository.findAll();}

    @Override
    public void guardarSolicitudDeServicios(SolicitudDeServicios solicitud) {solicitudDeServiciosRepository.save(solicitud);}


    @Override
    public SolicitudDeServicios obtenerSolicitudDeServiciosPorId(Integer id) {
        return solicitudDeServiciosRepository.findById(id).orElseThrow(()-> new RuntimeException("Solicitud de servicios no encontrada para el id"+ id));
    }

    @Override
    public void eliminarSolicitudDeServicios(Integer id) {
        if(solicitudDeServiciosRepository.existsById(id)) {
            solicitudDeServiciosRepository.deleteById(id);
        } else {
            throw new RuntimeException("Solicitud de servicios no encontrada" + id);
        }

    }
}
