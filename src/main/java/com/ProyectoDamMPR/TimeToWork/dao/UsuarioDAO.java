package com.ProyectoDamMPR.TimeToWork.dao;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.util.ArrayList;


public interface UsuarioDAO {
    public void crearUsuario(Usuario u);

    Usuario loginUsuario(CorreoContrasena correoContrasena);

    public Usuario updateUsuario(Usuario usuario);

    public ArrayList<Usuario> getUsuarios(Usuario usuario);

    public int RemoveUsuario(Usuario usuario);
}
