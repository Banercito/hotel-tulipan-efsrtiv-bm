package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.Suministro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuministroRepository extends JpaRepository<Suministro, Integer> {
    @Query(value = "SELECT * FROM suministro s WHERE s.nombre_suministro LIKE %:filtro% OR s.precio_adquisicion LIKE %:filtro%", nativeQuery = true)
    List<Suministro> findSuministroPorFiltro(@Param("filtro") String filtro);
}

