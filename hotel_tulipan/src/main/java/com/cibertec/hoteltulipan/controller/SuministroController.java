package com.cibertec.hoteltulipan.controller;


import com.cibertec.hoteltulipan.model.Suministro;
import com.cibertec.hoteltulipan.model.Usuario;

import com.cibertec.hoteltulipan.service.SuministroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/suministros")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class SuministroController {
    private final SuministroService suministroService;

    @GetMapping("/listarSuministros")
    public String verPaginaInicio(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaSuministros", suministroService.listarSuministros());
        return "suministros/suministros";
    }


    @GetMapping("/nuevoSuministro")
    public String nuevoSuministro(@SessionAttribute("usuario") Usuario usuario,Model model) {
        model.addAttribute("suministro", new Suministro());
        return "suministros/nuevoSuministro";
    }


    @PostMapping("/guardarSuministro")
    public String guardarSuministro(@ModelAttribute("suministro") Suministro suministro) {
        suministroService.guardarSuministro(suministro);
        return "redirect:/suministros/listarSuministros";
    }

    @GetMapping("/actualizarSuministro/{id}")
    public String actualizarSuministros(@SessionAttribute("usuario") Usuario usuario, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("suministro", suministroService.obtenerSuministroPorId(id));
        return "suministros/actualizarSuministro";
    }
    @GetMapping("/eliminarSuministro/{id}")
    public String eliminarSuministro(@PathVariable("id") Integer id) {
        suministroService.eliminarSuministro(id);
        return "redirect:/suministros/listarSuministros";
    }

    @GetMapping("/inicioBusqueda")
    public String verPaginaBusqueda(@SessionAttribute("usuario") Usuario usuario, Model model) {
        return "suministros/buscarSuministro";
    }

    @GetMapping("/busquedaSuministro")
    public String busquedaSuministro(@SessionAttribute("usuario") Usuario usuario, Model model,
                                    @RequestParam("filtro") String filtro) {
        List<Suministro> lista = suministroService.listarSuministroPorFiltro(filtro);
        model.addAttribute("listaSuministros", lista);
        model.addAttribute("usuario", usuario);
        model.addAttribute("filtro", filtro);
        return "suministros/suministros";
    }


    @GetMapping("/")
    public String index(@SessionAttribute("usuario") Usuario usuario, Model model) {
        if (usuario == null) {
            // Manejar el caso donde el usuario no está en la sesión
            return "redirect:/acceso/login";
        }
        model.addAttribute("usuario", usuario);
        return "redirect:/reclamos/listarReclamos";
    }

}
