package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Column(name = "idusuario") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombreusuario")
    private String nombreUsuario = null;
    @Column(name = "apellidosusuario")
    private String apellidosUsuario = null;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "direccion")
    private String direccion=null;
    @Column(name = "empresausuario")
    private String empresaUsuario = null;
    @Column(name = "lugartrabajo")
    private String lugarTrabajo = null;
    @Column(name = "fechanacimiento")
    private String fechaNacimiento = null;
    @Column(name = "correousuario")
    @NaturalId
    private String correoUsuario = null;
    @Column(name = "contrasena")
    private String contrasena = null;
    @Column(name = "esadmin")
    private boolean esAdmin = false;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idempresa")
    private Empresa empresa_fk;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_fk", cascade = CascadeType.ALL, orphanRemoval = true) //operaciones en cascada y horarios no asociados a usuarios eliminados
    private List<Horario> horarios = new ArrayList<Horario>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_fk", cascade = CascadeType.ALL, orphanRemoval = true) //operaciones en cascada y mensajes no asociados a usuarios eliminados
    private List<Mensaje> mensajes = new ArrayList<Mensaje>();

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String apellidosUsuario, int telefono, String direccion, String empresaUsuario, String lugarTrabajo, String fechaNacimiento, String correoUsuario, String contrasena, boolean esAdmin, Empresa empresa_fk, List<Horario> horarios, List<Mensaje> mensajes) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empresaUsuario = empresaUsuario;
        this.lugarTrabajo = lugarTrabajo;
        this.fechaNacimiento = fechaNacimiento;
        this.correoUsuario = correoUsuario;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
        this.empresa_fk = empresa_fk;
        this.horarios = horarios;
        this.mensajes = mensajes;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresaUsuario() {
        return empresaUsuario;
    }

    public void setEmpresaUsuario(String empresaUsuario) {
        this.empresaUsuario = empresaUsuario;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public Empresa getEmpresa_fk() {
        return empresa_fk;
    }

    public void setEmpresa_fk(Empresa empresa_fk) {
        this.empresa_fk = empresa_fk;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", apellidosUsuario='" + apellidosUsuario + '\'' +
                ", telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", empresaUsuario='" + empresaUsuario + '\'' +
                ", lugarTrabajo='" + lugarTrabajo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", correoUsuario='" + correoUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }
}
