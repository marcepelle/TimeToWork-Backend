package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity //Marcamos la clase como una entidad de hibernate para la persistencia en la base de datos
@Table(name="usuario") //Indicamos a que tabla haremos referencia en la base de datos con esta clase
public class Usuario implements Serializable {
    @Column(name = "idusuario") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //que va a ser clave primaria y que su valor será autogenerado
    private int idUsuario;
    @Column(name = "nombreusuario") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String nombreUsuario = null;
    @Column(name = "apellidosusuario") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String apellidosUsuario = null;
    @Column(name = "telefono") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private int telefono;
    @Column(name = "direccion") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String direccion=null;
    @Column(name = "empresausuario") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String empresaUsuario = null;
    @Column(name = "lugartrabajo") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String lugarTrabajo = null;
    @Column(name = "fechanacimiento") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String fechaNacimiento = null;
    @Column(name = "correousuario") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @NaturalId // representa un identificador natural
    private String correoUsuario = null;
    @Column(name = "contrasena", length = 256) //Indicamos a que columna de la tabla se hace referencia con este campo de clase y la longitud máxima de sus valores
    private String contrasena = null;
    @Column(name = "esadmin") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private boolean esAdmin = false;
    @ManyToOne(fetch = FetchType.EAGER) //Indicamos que la entidad tendrá una relación varios a uno con la entidad Empresa y que la carga de los objetos de la relación se produce en el mismo momento
    @JoinColumn(name = "idempresa") //Indicamos que campo de la clase Empresa corresponderá con la clave foranea
    private Empresa empresa_fk;

    @JsonIgnore //Indicamos que evite la serialización y la deserialización de este campo para evitar llamadas recursivas
    @OneToMany(mappedBy = "usuario_fk", cascade = CascadeType.ALL, orphanRemoval = true) //Indicamos que la relación con la entidad Horario es de uno a varios, cual es la clave foranea de Horario referenciada y definimos que las operaciones se hagan en cascada y horarios no asociados a usuarios que sean eliminados
    private List<Horario> horarios = new ArrayList<Horario>();

    @JsonIgnore //Indicamos que evite la serialización y la deserialización de este campo para evitar llamadas recursivas
    @OneToMany(mappedBy = "usuario_fk", cascade = CascadeType.ALL, orphanRemoval = true) //Indicamos que la relación con la entidad Mensaje es de uno a varios, cual es la clave foranea de Mensaje referenciada y definimos que las operaciones se hagan en cascada y mensajes no asociados a usuarios eliminados
    private List<Mensaje> mensajes = new ArrayList<Mensaje>();

    //Constructores
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

    //Getters y Setters

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

    //Método toString
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
