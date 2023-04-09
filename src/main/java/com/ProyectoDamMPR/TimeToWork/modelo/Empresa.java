package com.ProyectoDamMPR.TimeToWork.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Empresa")
public class Empresa {
    @Column(name = "idempresa") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;
    @Column(name = "CIF")
    private String cif;
    @Column(name = "nombreempresa")
    @NaturalId
    private String nombreEmpresa;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "nombreadmin")
    private String nombreadmin;
    @Column(name = "pais")
    private String pais;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(mappedBy = "empresa_fk", cascade = CascadeType.ALL, orphanRemoval = true) //operaciones en cascada y usuarios no asociados a empresa eliminados
    private List<Usuario> usuarios = new ArrayList<>();

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
