package com.cibertec.hoteltulipan.controller;

import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/pagos")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class PagoController {

    private final PagoService pagoService;

    @GetMapping("/listarPagos")
    public String verPaginaInicioPago(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaPagos", pagoService.listarPagos());
        return "pagos/pagos";
    }
}
