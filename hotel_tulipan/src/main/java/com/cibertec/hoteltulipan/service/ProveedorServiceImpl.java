package com.cibertec.hoteltulipan.service;
import com.cibertec.hoteltulipan.model.Proveedor;
import com.cibertec.hoteltulipan.repository.ProveedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listarProveedores() {return proveedorRepository.findAll();}


    @Override
    public void guardarProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Proveedor no encontrado para el id"+ id));
    }

    @Override
    public void eliminarProveedor(Integer id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Proveedor no encontrado para el id"+ id);
        }
    }

    @Override
    public List<Proveedor> listarProveedorPorFiltro(String filtro) {
        return proveedorRepository.findProveedorPorFiltro(filtro);
    }
}
