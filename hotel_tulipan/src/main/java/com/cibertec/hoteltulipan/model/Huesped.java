package com.cibertec.hoteltulipan.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "huesped")
@Data
@Getter
@Setter
public class Huesped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_huesped")
    private Integer idHuesped;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "correo", length = 100, nullable = false)
    private String correo;

    @Column(name = "direccion", length = 200, nullable = false)
    private String direccion;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNac;

    @Column(name = "fecha_reg")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReg;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "numero_documento", length = 20)
    private String numeroDocumento;

    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;
}
