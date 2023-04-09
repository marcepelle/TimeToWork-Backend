package com.ProyectoDamMPR.TimeToWork.modelo;

public class CorreoContrasena {
    private String correo;
    private String password;

    public CorreoContrasena() {
    }

    public CorreoContrasena(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CorreoContrasena{" +
                "correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
