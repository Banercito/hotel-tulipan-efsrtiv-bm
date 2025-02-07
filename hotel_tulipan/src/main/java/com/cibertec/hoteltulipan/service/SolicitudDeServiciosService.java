package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.SolicitudDeServicios;

import java.util.List;

public interface SolicitudDeServiciosService {
    List<SolicitudDeServicios> listarSolicitudDeServicios();
    void guardarSolicitudDeServicios(SolicitudDeServicios solicitud);
    SolicitudDeServicios obtenerSolicitudDeServiciosPorId(Integer id);
    void eliminarSolicitudDeServicios(Integer id);
}
