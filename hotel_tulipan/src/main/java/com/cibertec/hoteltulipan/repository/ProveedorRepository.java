package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Query(value = "SELECT * FROM proveedor p WHERE p.contacto LIKE %:filtro% OR p.nombre LIKE %:filtro%", nativeQuery = true)
    List<Proveedor> findProveedorPorFiltro(@Param("filtro") String filtro);
}

