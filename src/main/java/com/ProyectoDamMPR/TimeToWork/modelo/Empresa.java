package com.ProyectoDamMPR.TimeToWork.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Empresa")
public class Empresa {
    @Column @Id @GeneratedValue
    private int idEmpresa;
    @Column(name="CIF")
    private String cif;
    @Column
    private String nombreEmpresa;
    @Column
    private int telefono;
    @Column
    private String nombreadmin;
    @Column
    private String pais;
    @Column
    private String provincia;
    @Column
    private String ciudad;

    @OneToMany
    @JoinColumn(name="idEmpresa_fk")
    private List<Usuario> usuarios = new ArrayList<Usuario>();


    public Empresa() {
    }

    public Empresa(int idEmpresa, String cif, String nombreEmpresa, int telefono, String nombreAdmin, String pais, String provincia, String ciudad) {
        this.idEmpresa=idEmpresa;
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.nombreadmin = nombreAdmin;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }

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

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa='" + idEmpresa + '\'' +
                "CIF='" + cif + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", telefono=" + telefono +
                ", nombreAdmin='" + nombreadmin + '\'' +
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
