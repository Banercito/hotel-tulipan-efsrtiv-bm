package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.SolicitudDeServicios;
import com.cibertec.hoteltulipan.service.ServiciosAdicionalesService;
import com.cibertec.hoteltulipan.service.SolicitudDeServiciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudDeServiciosController {
    private final SolicitudDeServiciosService solicitudDeServiciosService;
    private final ServiciosAdicionalesService serviciosAdicionalesService;


    @GetMapping("/listarSolicitudes")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listaSolicitudes", solicitudDeServiciosService.listarSolicitudDeServicios());
                return "solicitudes/solicitudes";
    }

    @GetMapping("/eliminarSolicitud{id}")
    public String eliminarSolicitud(@PathVariable("id") Integer id) {
        solicitudDeServiciosService.eliminarSolicitudDeServicios(id);
        return "redirect:/solicitudes/listarSolicitud";
    }

    @GetMapping("/nuevoSolicitud")
    public String nuevoSolicitud( Model model) {
        model.addAttribute("solicitudDeServicios", new SolicitudDeServicios());
        model.addAttribute("listarServiciosAdicionales",serviciosAdicionalesService.listarServiciosAdicionales());
        return "solicitudes/nuevoSolicitud";
    }

    @PostMapping("/guardarSolicitud")
    public String guardarSolicitud(@ModelAttribute ("solicitud") SolicitudDeServicios solicitud) {
        solicitudDeServiciosService.guardarSolicitudDeServicios(solicitud);
        return "redirect:/solicitudes/listarSolicitud";

    }


}
