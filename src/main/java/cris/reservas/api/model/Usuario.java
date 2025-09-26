package cris.reservas.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUSUARIO")   // 👈 Nombre exacto de la tabla
    private Long idUsuario;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CARRERA")
    private String carrera;

    @Column(name = "CORREO")
    private String correo;

    // Getters y Setters
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}

