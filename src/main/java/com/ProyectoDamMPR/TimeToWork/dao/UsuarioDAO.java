package com.ProyectoDamMPR.TimeToWork.dao;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.util.ArrayList;


public interface UsuarioDAO { //Con esta interfaz declaramos los métodos abstractos de las funciones CRUD(Crear, leer, actualizar y borrar) para la entidad Usuario
    Usuario loginUsuario(CorreoContrasena correoContrasena); //Devolverá el usuario para la sesión si para el objeto CorreoContrasena pasado los datos son correctos
    public int crearUsuario(Usuario u); //Creará en la base de datos el usuario pasado
    public Usuario getUsuario(String correo); //Devuelve el usuario buscado a través del objeto correoContrasena
    public ArrayList<Usuario> getUsuarios(String empresa); //Devuelve el listado de usuarios para la empresa pasada
    public Usuario updateUsuario(Usuario usuario); //Actualiza y devuelve el usuario pasado
    public Usuario updateContrasena(Usuario usuario); //Actualiza la contraseña y devuelve el usuario actualizado
    public int RemoveUsuario(int idUsuario); //Devuelve una respuesta de tipo entero dependiendo de si consiguió eliminar o no el usuario pasado

}
