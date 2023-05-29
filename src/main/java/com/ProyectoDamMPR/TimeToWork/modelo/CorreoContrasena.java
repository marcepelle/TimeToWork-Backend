package com.ProyectoDamMPR.TimeToWork.modelo;

public class CorreoContrasena { //DTO(Objeto de transferencia de datos) para las peticiones
    //Campos de la clase
    private String correo;
    private String password;

    //Constructores
    public CorreoContrasena() {
    }

    public CorreoContrasena(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    //Getters y Setters
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

    //toString
    @Override
    public String toString() {
        return "CorreoContrasena{" +
                "correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
