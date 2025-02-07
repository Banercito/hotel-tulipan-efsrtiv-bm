package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.Cargo;
import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cargos")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class CargoController {
    private final CargoService cargoService;

    @GetMapping("/listarCargos")
    public String verPaginaInicioCargo(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaCargos", cargoService.listarCargos());
        return "cargos/cargos";
    }


    @GetMapping("/nuevoCargo")
    public String nuevoCargo(@SessionAttribute("usuario") Usuario usuario,Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargos/nuevoCargo";
    }


    @PostMapping("/guardarCargo")
    public String guardarCargo(@ModelAttribute("cargo") Cargo cargo) {
        cargoService.guardarCargo(cargo);
        return "redirect:/cargos/listarCargos";
    }

    @GetMapping("/actualizarCargo/{id}")
    public String actualizarCargo(@SessionAttribute("usuario") Usuario usuario, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("cargo", cargoService.obtenerCargoPorId(id));
        return "cargos/actualizarCargo";
    }
    @GetMapping("/eliminarCargo/{id}")
    public String eliminarCargo(@PathVariable("id") Integer id) {
        cargoService.eliminarCargo(id);
        return "redirect:/cargos/listarCargos";
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
