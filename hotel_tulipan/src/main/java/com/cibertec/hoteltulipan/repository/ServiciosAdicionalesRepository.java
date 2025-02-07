package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.ServiciosAdicionales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosAdicionalesRepository extends JpaRepository<ServiciosAdicionales,Integer> {

}
