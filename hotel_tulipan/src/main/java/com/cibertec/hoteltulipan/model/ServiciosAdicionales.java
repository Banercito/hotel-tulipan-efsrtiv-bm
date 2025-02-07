package com.cibertec.hoteltulipan.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicios_adicionales")
@Data
@Getter
@Setter
public class ServiciosAdicionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio_adicional")
    private Integer idServicioAdicional;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "precio_venta", nullable = false)
    private int precioVenta;
}
