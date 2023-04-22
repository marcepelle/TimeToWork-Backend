package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Mensaje")
public class Mensaje {
    @Column(name = "idmensaje") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @Column(name = "de")
    private String de;

    @Column(name = "para")
    private String para;

    @Column(name = "fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "nomempresa")
    private String nomEmpresa;

    @Column(name = "centrode")
    private String centroDe;

    @Column(name = "centropara")
    private String centroPara;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "contenido", length = 65535)
    private String contenido;

    @Column(name = "visto")
    private boolean visto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idusuario")
    private Usuario usuario_fk;

    public Mensaje() {
    }

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

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public Usuario getUsuario_fk() {
        return usuario_fk;
    }

    public void setUsuario_fk(Usuario usuario_fk) {
        this.usuario_fk = usuario_fk;
    }

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
                ", visto=" + visto +
                '}';
    }
}
