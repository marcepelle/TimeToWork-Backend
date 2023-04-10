package com.ProyectoDamMPR.TimeToWork.dao;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;


public interface UsuarioDAO {
    public void crearUsuario(Usuario u);

    Usuario loginUsuario(CorreoContrasena correoContrasena);
}
