package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value = "SELECT * FROM reserva r WHERE r.estado LIKE %:filtro% OR r.id_huesped IN " +
            "(SELECT id_huesped FROM huesped WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro%)",
            nativeQuery = true)
    List<Reserva> findReservaPorFiltro(@Param("filtro") String filtro);
}
