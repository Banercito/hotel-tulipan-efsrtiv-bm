package com.cibertec.hoteltulipan.controller;


import com.cibertec.hoteltulipan.model.Proveedor;
import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proveedores")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class ProveedorController {
    private final ProveedorService proveedorService;

    @GetMapping("/listarProveedores")
    public String verPaginaInicio(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaProveedores", proveedorService.listarProveedores());
        return "proveedores/proveedores";
    }


    @GetMapping("/nuevoProveedor")
    public String nuevoProveedor(@SessionAttribute("usuario") Usuario usuario,Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores/nuevoProveedor";
    }


    @PostMapping("/guardarProveedor")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores/listarProveedores";
    }

    @GetMapping("/actualizarProveedor/{id}")
    public String actualizarProveedor(@SessionAttribute("usuario") Usuario usuario, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("proveedor", proveedorService.obtenerProveedorPorId(id));
        return "proveedores/actualizarProveedor";
    }
    @GetMapping("/eliminarProveedor/{id}")
    public String eliminarProveedor(@PathVariable("id") Integer id) {
        proveedorService.eliminarProveedor(id);
        return "redirect:/proveedores/listarProveedores";
    }

    @GetMapping("/inicioBusqueda")
    public String verPaginaBusqueda(@SessionAttribute("usuario") Usuario usuario, Model model) {
        return "proveedores/buscarProveedor";
    }

    @GetMapping("/busquedaProveedor")
    public String busquedaProveedor(@SessionAttribute("usuario") Usuario usuario, Model model,
                                    @RequestParam("filtro") String filtro) {
        List<Proveedor> lista = proveedorService.listarProveedorPorFiltro(filtro);
        model.addAttribute("listaProveedores", lista);
        model.addAttribute("usuario", usuario);
        model.addAttribute("filtro", filtro);
        return "proveedores/proveedores";
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
