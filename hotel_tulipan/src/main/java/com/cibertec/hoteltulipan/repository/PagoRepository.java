package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago,Integer> {
}
