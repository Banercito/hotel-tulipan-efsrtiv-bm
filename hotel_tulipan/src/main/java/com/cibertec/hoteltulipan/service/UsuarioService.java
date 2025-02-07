package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Usuario;

public interface UsuarioService {
    Usuario obtenerUsuario(String nombreUsuario, String contrasena);
    void guardarUsuario(Usuario usuario);
}