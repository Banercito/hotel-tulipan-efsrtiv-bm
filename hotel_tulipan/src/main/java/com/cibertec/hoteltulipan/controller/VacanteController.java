package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.model.Vacante;
import com.cibertec.hoteltulipan.service.CargoService;
import com.cibertec.hoteltulipan.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacantes")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class VacanteController {
    private final VacanteService vacanteService;
    private final CargoService cargoService;

    @GetMapping("/listarVacantes")
    public String verPaginaInicio(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaVacantes", vacanteService.listarVacantes());
        return "vacantes/vacantes";
    }

    @GetMapping("/nuevoVacante")
    public String nuevoVacante(@SessionAttribute("usuario") Usuario usuario,Model model) {
        model.addAttribute("vacante", new Vacante());
        model.addAttribute("listarCargos", cargoService.listarCargos());
        return "vacantes/nuevoVacante";
    }

    @PostMapping("/guardarVacante")
    public String guardarVacante(@ModelAttribute("vacante") Vacante vacante) {
        vacanteService.guardarVacante(vacante);
        return "redirect:/vacantes/listarVacantes";
    }

    @GetMapping("/actualizarVacante/{id}")
    public String actualizarVacante(@SessionAttribute("usuario") Usuario usuario, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("vacante", vacanteService.obtenerVacantePorId(id));
        model.addAttribute("listarCargos", cargoService.listarCargos());
        return "vacantes/actualizarVacante";
    }
    @GetMapping("/eliminarVacante/{id}")
    public String eliminarVacante(@PathVariable("id") Integer id) {
        vacanteService.eliminarVacante(id);
        return "redirect:/vacantes/listarVacantes";
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
