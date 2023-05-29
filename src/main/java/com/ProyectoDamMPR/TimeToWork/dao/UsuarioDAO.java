package com.ProyectoDamMPR.TimeToWork.dao;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.util.ArrayList;


public interface UsuarioDAO { //Con esta interfaz declaramos los métodos abstractos de las funciones CRUD(Crear, leer, actualizar y borrar) para la entidad Usuario
    Usuario loginUsuario(CorreoContrasena correoContrasena); //Devolverá el usuario para la sesión si para el objeto CorreoContrasena pasado los datos son correctos
    public void crearUsuario(Usuario u); //Creará en la base de datos el usuario pasado
    public Usuario getUsuario(CorreoContrasena correoContrasena); //Devuelve el usuario buscado a través del objeto correoContrasena
    public ArrayList<Usuario> getUsuarios(Usuario usuario); //Devuelve el listado de usuarios para el usuario pasado
    public Usuario updateUsuario(Usuario usuario); //Actualiza y devuelve el usuario pasado
    public int RemoveUsuario(Usuario usuario); //Devuelve una respuesta de tipo entero dependiendo de si consiguió eliminar o no el usuario pasado
}
