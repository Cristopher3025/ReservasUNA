package cris.reservas.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVAS")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDRESERVA")
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "IDSALA", referencedColumnName = "IDSALA")
    private Sala sala;

    @Column(name = "FECHARESERVA")
    private LocalDate fechaReserva;

    @Column(name = "HORAINICIO")
    private String horaInicio;

    @Column(name = "HORAFIN")
    private String horaFin;

    // Getters y Setters
    public Long getIdReserva() { return idReserva; }
    public void setIdReserva(Long idReserva) { this.idReserva = idReserva; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }

    public LocalDate getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDate fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }
}

