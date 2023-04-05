package com.ProyectoDamMPR.TimeToWork.interfaces;

import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

public interface UsuarioInterface {
    public int crearUsuario(Usuario u);
    public int crearEmpresaUsuario(Empresa empresa);
    public Usuario loginUsuario(String correoUsuario, String contrasena);
}
