package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Horario")
public class Horario {
    @Column(name = "idhorario") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;
    @Column(name = "empleado")
    private String empleado = null;
    @Column(name = "correoempleado")
    private String correoEmpleado = null;
    @Column(name = "fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @Column(name = "centrotrabajo")
    private String centroTrabajo = null;
    @Column(name = "horaentrada")
    private LocalTime horaEntrada;
    @Column(name = "horasalida")
    private LocalTime horaSalida;
    @Column(name = "fichaentrada")
    private LocalTime fichaEntrada;
    @Column(name = "fichasalida")
    private LocalTime fichaSalida;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idusuario")
    private Usuario usuario_fk;

    public Horario() {
    }

    public Horario(int idHorario, String empleado, String correoEmpleado, LocalDate fecha, String centroTrabajo, LocalTime horaEntrada, LocalTime horaSalida, LocalTime fichaEntrada, LocalTime fichaSalida, Usuario usuario_fk) {
        this.idHorario = idHorario;
        this.empleado = empleado;
        this.correoEmpleado = correoEmpleado;
        this.fecha = fecha;
        this.centroTrabajo = centroTrabajo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fichaEntrada = fichaEntrada;
        this.fichaSalida = fichaSalida;
        this.usuario_fk = usuario_fk;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCentroTrabajo() {
        return centroTrabajo;
    }

    public void setCentroTrabajo(String centroTrabajo) {
        this.centroTrabajo = centroTrabajo;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getFichaEntrada() {
        return fichaEntrada;
    }

    public void setFichaEntrada(LocalTime fichaEntrada) {
        this.fichaEntrada = fichaEntrada;
    }

    public LocalTime getFichaSalida() {
        return fichaSalida;
    }

    public void setFichaSalida(LocalTime fichaSalida) {
        this.fichaSalida = fichaSalida;
    }

    public Usuario getUsuario_fk() {
        return usuario_fk;
    }

    public void setUsuario_fk(Usuario usuario_fk) {
        this.usuario_fk = usuario_fk;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "idHorario=" + idHorario +
                ", empleado='" + empleado + '\'' +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", fecha=" + fecha +
                ", centroTrabajo='" + centroTrabajo + '\'' +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", fichaEntrada=" + fichaEntrada +
                ", fichaSalida=" + fichaSalida +
                '}';
    }
}
