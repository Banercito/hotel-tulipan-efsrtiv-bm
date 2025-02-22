package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.Reserva;
import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.EmpleadoService;
import com.cibertec.hoteltulipan.service.HabitacionService;
import com.cibertec.hoteltulipan.service.HuespedService;
import com.cibertec.hoteltulipan.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;
    private final HabitacionService habitacionService;
    private final EmpleadoService empleadoService;
    private final HuespedService huespedService;

    @GetMapping("/listarReservas")
    public String verPaginaInicio(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaReservas", reservaService.listarReservas());

        return "reservas/reservas";
    }

    @GetMapping("/nuevaReserva")
    public String nuevaReserva(@SessionAttribute("usuario") Usuario usuario,Model model) {
        Reserva reserva = new Reserva();
        reserva.setEstado("Pendiente");
        model.addAttribute("reserva", reserva);
        model.addAttribute("listarHabitaciones", habitacionService.listarHabitaciones());
        model.addAttribute("listarEmpleados", empleadoService.listarEmpleados());
        model.addAttribute("listarHuespedes", huespedService.listarHuespedes());
        return "reservas/nuevaReserva";
    }

    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva) {
        if (reserva.getEstado() == null) {
            reserva.setEstado("Pendiente");
        }
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas/listarReservas";
    }

    @GetMapping("/actualizarReserva/{id}")
    public String actualizarReserva(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("reserva", reservaService.obtenerReservaPorId(id));
        return "reservas/actualizarReserva";
    }

    @GetMapping("/eliminarReserva/{id}")
    public String eliminarReserva(@PathVariable("id") Integer id) {
        reservaService.eliminarReserva(id);
        return "redirect:/reservas/listarReservas";
    }

    @GetMapping("/busquedaReserva")
    public String busquedaReserva(@SessionAttribute("usuario") Usuario usuario, Model model, @RequestParam("filtro") String filtro) {
        List<Reserva> lista = reservaService.listarReservasPorFiltro(filtro);
        model.addAttribute("listaReservas", lista);
        model.addAttribute("usuario", usuario);
        model.addAttribute("filtro", filtro);
        return "reservas/reservas";
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
