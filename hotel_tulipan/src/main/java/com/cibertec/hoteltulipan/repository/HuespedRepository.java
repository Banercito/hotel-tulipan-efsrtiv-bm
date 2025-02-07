package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Integer> {
    @Query(value = "SELECT * FROM huesped h WHERE h.nombre LIKE %:filtro% OR h.apellido LIKE %:filtro%", nativeQuery = true)
    List<Huesped> findHuespedPorFiltro(@Param("filtro") String filtro);
}
