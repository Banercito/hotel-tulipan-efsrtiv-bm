package com.cibertec.hoteltulipan.repository;

import com.cibertec.hoteltulipan.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
