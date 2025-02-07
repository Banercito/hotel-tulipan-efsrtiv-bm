package com.cibertec.hoteltulipan.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proveedor")
@Data
@Getter
@Setter
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "contacto", length = 100, nullable = false)
    private String contacto;

    @Column(name = "correo", length = 100, nullable = false)
    private String correo;

    @Column(name = "direccion", length = 200, nullable = false)
    private String direccion;

    @Column(name = "estado", length = 10, nullable = false)
    private String estado = "A";

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;
}
