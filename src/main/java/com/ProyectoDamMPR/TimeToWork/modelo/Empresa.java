package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity //Marcamos la clase como una entidad de hibernate para la persistencia en la base de datos
@Table(name="Empresa") //Indicamos a que tabla haremos referencia en la base de datos con esta clase
public class Empresa implements Serializable {
    @Column(name = "idempresa") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //que va a ser clave primaria y que su valor será autogenerado
    private int idEmpresa;
    @Column(name = "CIF") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String cif;
    @Column(name = "nombreempresa") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    @NaturalId //representa un identificador natural
    private String nombreEmpresa;
    @Column(name = "telefono") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private int telefono;
    @Column(name = "nombreadmin") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String nombreadmin;
    @Column(name = "pais") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String pais;
    @Column(name = "provincia") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String provincia;
    @Column(name = "ciudad") //Indicamos a que columna de la tabla se hace referencia con este campo de clase
    private String ciudad;
    @JsonIgnore //Indicamos que evite la serialización y la deserialización de este campo para evitar llamadas recursivas
    @OneToMany(mappedBy = "empresa_fk", cascade = CascadeType.ALL, orphanRemoval = true) //Indicamos que la relación con la entidad Usuario es de uno a varios, cual es la clave foranea de Usuario referenciada y definimos que las operaciones se hagan en cascada y usuarios no asociados a empresas eliminados
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    //Constructores
    public Empresa() {
    }

    public Empresa(int idEmpresa, String cif, String nombreEmpresa, int telefono, String nombreadmin, String pais, String provincia, String ciudad, List<Usuario> usuarios) {
        this.idEmpresa = idEmpresa;
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.nombreadmin = nombreadmin;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.usuarios = usuarios;
    }

    //Getters y Setters
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombreadmin() {
        return nombreadmin;
    }

    public void setNombreadmin(String nombreadmin) {
        this.nombreadmin = nombreadmin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    //Método toString
    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", cif='" + cif + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", telefono=" + telefono +
                ", nombreadmin='" + nombreadmin + '\'' +
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
