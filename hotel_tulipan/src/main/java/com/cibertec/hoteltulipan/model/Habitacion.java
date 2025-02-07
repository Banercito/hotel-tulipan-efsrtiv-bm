package com.cibertec.hoteltulipan.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "habitacion")
@Data
@Getter
@Setter
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;
}
