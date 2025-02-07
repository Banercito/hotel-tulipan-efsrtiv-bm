package com.cibertec.hoteltulipan.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "suministros")
@Data
@Getter
@Setter
public class Suministros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suministro")
    private Integer idSuministro;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "fecha_adquisicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_servicio_adicional", nullable = false)
    private ServiciosAdicionales servicioAdicional;

    @Column(name = "nombre_suministro", length = 100, nullable = false)
    private String nombreSuministro;

    @Column(name = "precio_adquisicion", nullable = false)
    private double precioAdquisicion;
}
