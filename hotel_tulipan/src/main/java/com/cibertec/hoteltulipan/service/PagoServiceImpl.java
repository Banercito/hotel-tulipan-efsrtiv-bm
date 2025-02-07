package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Pago;
import com.cibertec.hoteltulipan.repository.PagoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PagoServiceImpl implements PagoService{
    private final PagoRepository pagoRepository;

    @Override
    public List<Pago> listarPagos() {return pagoRepository.findAll();}
}
