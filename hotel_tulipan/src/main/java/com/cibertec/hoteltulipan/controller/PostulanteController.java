package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.Postulante;
import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.PostulanteService;
import com.cibertec.hoteltulipan.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/postulantes")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class PostulanteController {
    private final PostulanteService postulanteService;
    private final VacanteService vacanteService;

    @GetMapping("/listarPostulantes")
    public String verPaginaInicioPostulantes(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaPostulantes", postulanteService.listarPostulantes());
        return "postulantes/postulantes";
    }

    @GetMapping("/nuevoPostulante")
    public String nuevoPostulante(@SessionAttribute("usuario") Usuario usuario,Model model) {
        model.addAttribute("postulante", new Postulante());
        model.addAttribute("listarVacantes", vacanteService.listarVacantes());
        return "postulantes/nuevoPostulante";
    }

    @PostMapping("/guardarPostulante")
    public String guardarProveedor(@ModelAttribute("postulante") Postulante postulante) {
        postulanteService.guardarPostulante(postulante);
        return "redirect:/postulantes/listarPostulantes";
    }

    @GetMapping("/actualizarPostulante/{id}")
    public String actualizarPostulante(@SessionAttribute("usuario") Usuario usuario, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("postulante", postulanteService.obtenerPostulantePorId(id));
        model.addAttribute("listarVacantes", vacanteService.listarVacantes());
        return "postulantes/actualizarPostulante";
    }

    @GetMapping("/eliminarPostulante/{id}")
    public String eliminarPostulante(@PathVariable("id") Integer id) {
        postulanteService.eliminarPostulante(id);
        return "redirect:/postulantes/listarPostulantes";
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
