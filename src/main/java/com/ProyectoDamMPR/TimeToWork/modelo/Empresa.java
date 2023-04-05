package com.ProyectoDamMPR.TimeToWork.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empresa {
    @Column @Id
    private String CIF;
    @Column
    private String nombreEmpresa;
    @Column
    private int telefono;
    @Column
    private String nombreAdmin;
    @Column
    private String pais;
    @Column
    private String provincia;
    @Column
    private String ciudad;

    public Empresa() {
    }

    public Empresa(String CIF, String nombreEmpresa, int telefono, String nombreAdmin, String pais, String provincia, String ciudad) {
        this.CIF = CIF;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.nombreAdmin = nombreAdmin;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
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

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
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
                "CIF='" + CIF + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", telefono=" + telefono +
                ", nombreAdmin='" + nombreAdmin + '\'' +
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
