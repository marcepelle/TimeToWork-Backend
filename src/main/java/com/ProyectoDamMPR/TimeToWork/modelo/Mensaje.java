package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity //Marcamos la clase como una entidad de hibernate para la persistencia en la base de datos
@Table(name = "Mensaje") //Indicamos a que tabla haremos referencia en la base de datos con esta clase
public class Mensaje {
    @Column(name = "idmensaje") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //que va a ser clave primaria y que su valor será autogenerado
    private int idMensaje;

    @Column(name = "de") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String de;

    @Column(name = "para") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String para;

    @Column(name = "fecha") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @JsonFormat(pattern = "yyyy-MM-dd") //Formato de la fecha al serializar y deserializar el Mensaje
    private LocalDate fecha;

    @Column(name = "hora") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private LocalTime hora;

    @Column(name = "nomempresa") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String nomEmpresa;

    @Column(name = "centrode") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String centroDe;

    @Column(name = "centropara") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String centroPara;

    @Column(name = "asunto") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String asunto;

    @Column(name = "contenido", length = 65535) //Indicamos a que columna de la tabla se hace referencia con este campo de clase y la longitud máxima de sus valores
    private String contenido;

    @Column(name = "vistode") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private boolean vistoDe;

    @Column(name = "vistopara") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private boolean vistoPara;

    @ManyToOne(fetch = FetchType.EAGER) //Indicamos que la entidad tendrá una relación varios a uno con la entidad Usuario y que la carga de los objetos de la relación se produce en el mismo momento
    @JoinColumn(name = "idusuario") //Indicamos que campo de la clase Usuario corresponderá con la clave foranea
    private Usuario usuario_fk;

    //Constructores
    public Mensaje() {
    }

    public Mensaje(int idMensaje, String de, String para, LocalDate fecha, LocalTime hora, String nomEmpresa, String centroDe, String centroPara, String asunto, String contenido, boolean vistoDe, boolean vistoPara, Usuario usuario_fk) {
        this.idMensaje = idMensaje;
        this.de = de;
        this.para = para;
        this.fecha = fecha;
        this.hora = hora;
        this.nomEmpresa = nomEmpresa;
        this.centroDe = centroDe;
        this.centroPara = centroPara;
        this.asunto = asunto;
        this.contenido = contenido;
        this.vistoDe = vistoDe;
        this.vistoPara = vistoPara;
        this.usuario_fk = usuario_fk;
    }


    //Getters y Setters
    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getCentroDe() {
        return centroDe;
    }

    public void setCentroDe(String centroDe) {
        this.centroDe = centroDe;
    }

    public String getCentroPara() {
        return centroPara;
    }

    public void setCentroPara(String centroPara) {
        this.centroPara = centroPara;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario_fk() {
        return usuario_fk;
    }

    public void setUsuario_fk(Usuario usuario_fk) {
        this.usuario_fk = usuario_fk;
    }

    public boolean isVistoDe() {
        return vistoDe;
    }

    public void setVistoDe(boolean vistoDe) {
        this.vistoDe = vistoDe;
    }

    public boolean isVistoPara() {
        return vistoPara;
    }

    public void setVistoPara(boolean vistoPara) {
        this.vistoPara = vistoPara;
    }

    //Método toString
    @Override
    public String toString() {
        return "Mensaje{" +
                "idMensaje=" + idMensaje +
                ", de='" + de + '\'' +
                ", para='" + para + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", nomEmpresa='" + nomEmpresa + '\'' +
                ", centroDe='" + centroDe + '\'' +
                ", centroPara='" + centroPara + '\'' +
                ", asunto='" + asunto + '\'' +
                ", contenido='" + contenido + '\'' +
                ", vistoDe=" + vistoDe +
                ", vistoPara=" + vistoPara +
                '}';
    }
}
