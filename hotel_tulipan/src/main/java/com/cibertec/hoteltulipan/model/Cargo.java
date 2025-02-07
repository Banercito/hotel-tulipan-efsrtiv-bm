package com.cibertec.hoteltulipan.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "cargo")
@Data
@Getter
@Setter
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Integer idCargo;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "cargo")
    private List<Empleado> empleados;
}
