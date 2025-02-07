package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/acceso")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class LoginController {

    private final UsuarioService usuarioService;

    @GetMapping(value="/login")
    public String inicioLogin(){
        return "acceso/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("nombreUsuario") String nombreUsuario,
                        @RequestParam("contrasena") String contrasena,
                        Model model){

        Usuario usuario = usuarioService.obtenerUsuario(nombreUsuario, contrasena);
        if(usuario==null){
            model.addAttribute("error", "Usuario y/o contraseña incorrectos");
            return "redirect:/acceso/login?error=true";
        }

        model.addAttribute("usuario", usuario);
        return "acceso/index";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/acceso/login?logout=true";
    }
}

