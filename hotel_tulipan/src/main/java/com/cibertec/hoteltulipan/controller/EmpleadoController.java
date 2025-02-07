package com.cibertec.hoteltulipan.controller;


import com.cibertec.hoteltulipan.model.Empleado;
import com.cibertec.hoteltulipan.model.Usuario;
import com.cibertec.hoteltulipan.service.EmpleadoService;
import com.cibertec.hoteltulipan.service.CargoService;
import com.cibertec.hoteltulipan.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class EmpleadoController {
    private final EmpleadoService empleadoService;
    private final CargoService cargoService;
    private final UsuarioService usuarioService;

    @GetMapping("/listarEmpleados")
    public String verPaginaInicioEmpleados(@SessionAttribute("usuario") Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaEmpleados", empleadoService.listarEmpleados());
        return "empleados/empleados";
    }


    @GetMapping("/nuevoEmpleado")
    public String nuevoEmpleado(@SessionAttribute("usuario") Usuario usuario,Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("listarCargos", cargoService.listarCargos());
        return "empleados/nuevoEmpleado";
    }


    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        Usuario usuario = empleado.getUsuario();
        if (usuario.getIdUsuario() == null) {
            if (usuario.getNombreUsuario() == null || usuario.getNombreUsuario().isEmpty()) {
                usuario.setNombreUsuario(empleado.getNombre()); // Asigna un nombre de usuario que es el nombre que pone
            }
            if (usuario.getContrasena() == null || usuario.getContrasena().isEmpty()) {
                usuario.setContrasena("contraseña123"); // Asigna una contraseña por defecto o maneja esto según tu lógica
            }
            usuarioService.guardarUsuario(usuario);
        }
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados/listarEmpleados";
    }

    @GetMapping("/actualizarEmpleado/{id}")
    public String actualizarEmpleado(@SessionAttribute("usuario") Usuario usuario, @PathVariable("id") Integer id, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        if (empleado.getUsuario() == null) {
            empleado.setUsuario(new Usuario());
        }
        model.addAttribute("empleado", empleado);
        model.addAttribute("listarCargos", cargoService.listarCargos());
        return "empleados/actualizarEmpleado";
    }

    @PostMapping("/actualizarEmpleado")
    public String actualizarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        Usuario usuario = empleado.getUsuario();
        if (usuario != null && usuario.getIdUsuario() != null) {
            // Actualiza el usuario existente
            usuarioService.guardarUsuario(usuario);
        }
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados/listarEmpleados";
    }

        @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer id) {
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados/listarEmpleados";
    }

    @GetMapping("/inicioBusqueda")
    public String verPaginaBusquedaEmpleado(@SessionAttribute("usuario") Usuario usuario, Model model) {
        return "empleados/buscarEmpleado";
    }

    @GetMapping("/busquedaEmpleado")
    public String busquedaEmpleado(@SessionAttribute("usuario") Usuario usuario, Model model,
                                   @RequestParam("filtro") String filtro) {
        List<Empleado> lista = empleadoService.listarEmpleadoPorFiltro(filtro);
        model.addAttribute("listaEmpleados", lista);
        model.addAttribute("usuario", usuario);
        model.addAttribute("filtro", filtro);
        return "empleados/empleados";
    }

    @GetMapping("/")
    public String index(@SessionAttribute("usuario") Usuario usuario, Model model) {
        if (usuario == null) {
            // Manejar el caso donde el usuario no está en la sesión
            return "redirect:/acceso/login";
        }
        model.addAttribute("usuario", usuario);
        return "redirect:/empleados/listarEmpleados";
    }
}
