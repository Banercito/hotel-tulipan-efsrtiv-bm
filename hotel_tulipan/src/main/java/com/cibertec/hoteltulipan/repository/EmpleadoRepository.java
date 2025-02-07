package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query(value = "SELECT * FROM empleado e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%", nativeQuery = true)
    List<Empleado> findEmpleadoPorFiltro(@Param("filtro") String filtro);
}
