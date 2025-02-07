package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> listarProveedores();
    void guardarProveedor(Proveedor proveedor);
    Proveedor obtenerProveedorPorId(Integer id);
    void eliminarProveedor(Integer id);
    List<Proveedor> listarProveedorPorFiltro(String filtro);
}
