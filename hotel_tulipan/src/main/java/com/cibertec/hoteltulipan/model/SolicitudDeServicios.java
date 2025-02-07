package com.cibertec.hoteltulipan.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "solicitud_de_servicios")
@Data
@Getter
@Setter
public class SolicitudDeServicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "estado", length = 10, nullable = false)
    private String estado = "P";

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_servicio_adicional", nullable = false)
    private ServiciosAdicionales servicioAdicional;
}
