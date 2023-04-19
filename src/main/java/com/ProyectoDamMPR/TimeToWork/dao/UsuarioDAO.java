package com.ProyectoDamMPR.TimeToWork.dao;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.util.ArrayList;


public interface UsuarioDAO {
    Usuario loginUsuario(CorreoContrasena correoContrasena);
    public void crearUsuario(Usuario u);
    public Usuario getUsuario(CorreoContrasena correoContrasena);
    public ArrayList<Usuario> getUsuarios(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public int RemoveUsuario(Usuario usuario);
}
