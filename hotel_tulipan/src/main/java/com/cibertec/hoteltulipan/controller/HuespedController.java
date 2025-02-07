package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.Huesped;
import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.HuespedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/huespedes")
@RequiredArgsConstructor
public class HuespedController {

    private final HuespedService huespedService;

    @GetMapping("/listarHuespedes")
    public String verPaginaInicio(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaHuespedes", huespedService.listarHuespedes());
        return "huespedes/huespedes";
    }

    @GetMapping("/nuevoHuesped")
    public String nuevoHuesped(Model model) {
        Huesped huesped = new Huesped();
        huesped.setEstado("Activo");
        model.addAttribute("huesped", huesped);
        return "huespedes/nuevoHuesped";
    }

    @PostMapping("/guardarHuesped")
    public String guardarHuesped(@ModelAttribute("huesped") Huesped huesped) {
        huesped.setFechaReg(Date.valueOf(LocalDate.now()));

        if (huesped.getEstado() == null) {
            huesped.setEstado("Activo");
        }
        huespedService.guardarHuesped(huesped);

        return "redirect:/huespedes/listarHuespedes";
    }

    @GetMapping("/actualizarHuesped/{id}")
    public String actualizarHuesped(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("huesped", huespedService.obtenerHuespedPorId(id));
        return "huespedes/actualizarHuesped";
    }

    @GetMapping("/eliminarHuesped/{id}")
    public String eliminarHuesped(@PathVariable("id") Integer id) {
        huespedService.eliminarHuesped(id);
        return "redirect:/huespedes/listarHuespedes";
    }

    @GetMapping("/inicioBusqueda")
    public String verPaginaBusqueda(@SessionAttribute("usuario") Usuario usuario, Model model) {
        return "huespedes/buscarHuesped";
    }

    @GetMapping("/busquedaHuesped")
    public String busquedaHuesped(@SessionAttribute("usuario") Usuario usuario, Model model, @RequestParam("filtro") String filtro) {
        List<Huesped> lista = huespedService.listarHuespedPorFiltro(filtro);
        model.addAttribute("listaHuespedes", lista);
        model.addAttribute("usuario", usuario);
        model.addAttribute("filtro", filtro);
        return "huespedes/huespedes";
    }

}
