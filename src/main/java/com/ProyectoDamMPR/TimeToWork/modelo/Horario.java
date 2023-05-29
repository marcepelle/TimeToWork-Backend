package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity //Marcamos la clase como una entidad de hibernate para la persistencia en la base de datos
@Table(name = "Horario") //Indicamos a que tabla haremos referencia en la base de datos con esta clase
public class Horario {
    @Column(name = "idhorario") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //que va a ser clave primaria y que su valor será autogenerado
    private int idHorario;
    @Column(name = "empleado") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String empleado = null;
    @Column(name = "correoempleado") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String correoEmpleado = null;
    @Column(name = "fecha") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @JsonFormat(pattern = "yyyy-MM-dd") //Formato de la fecha al serializar y deserializar el Mensaje
    private LocalDate fecha;
    @Column(name = "centrotrabajo") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String centroTrabajo = null;
    @Column(name = "horaentrada") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private LocalTime horaEntrada;
    @Column(name = "horasalida") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private LocalTime horaSalida;
    @Column(name = "fichaentrada") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private LocalTime fichaEntrada;
    @Column(name = "fichasalida") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private LocalTime fichaSalida;
    @ManyToOne(fetch = FetchType.EAGER) //Indicamos que la entidad tendrá una relación varios a uno con la entidad Usuario y que la carga de los objetos de la relación se produce en el mismo momento
    @JoinColumn(name = "idusuario") //Indicamos que campo de la clase Usuario corresponderá con la clave foranea
    private Usuario usuario_fk;

    //Constructores
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

    //Getters y Setters
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

    //Método toString
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
