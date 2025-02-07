package com.cibertec.hoteltulipan.service;

import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl  implements UsuarioService{
    private final UsuarioRepository usuarioRepository;
    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
    }

    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}