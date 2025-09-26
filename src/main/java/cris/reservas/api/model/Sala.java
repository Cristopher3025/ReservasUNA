package cris.reservas.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SALAS")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSALA")
    private Long idSala;

    @Column(name = "NOMBRESALA")
    private String nombreSala;

    @Column(name = "CAPACIDAD")
    private int capacidad;

    @Column(name = "ESTADO")
    private String estado;

    // Getters y Setters
    public Long getIdSala() { return idSala; }
    public void setIdSala(Long idSala) { this.idSala = idSala; }

    public String getNombreSala() { return nombreSala; }
    public void setNombreSala(String nombreSala) { this.nombreSala = nombreSala; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
