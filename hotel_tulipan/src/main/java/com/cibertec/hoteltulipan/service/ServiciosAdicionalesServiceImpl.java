package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.ServiciosAdicionales;
import com.cibertec.hoteltulipan.repository.ServiciosAdicionalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiciosAdicionalesServiceImpl implements ServiciosAdicionalesService{
    private final ServiciosAdicionalesRepository serviciosAdicionalesRepository;

    @Override
    public List<ServiciosAdicionales> listarServiciosAdicionales() {
        return serviciosAdicionalesRepository.findAll();
    }
}
