package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.SolicitudDeServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudDeServiciosRepository extends JpaRepository<SolicitudDeServicios,Integer> {
}
