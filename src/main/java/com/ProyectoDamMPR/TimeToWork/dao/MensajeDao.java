package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Mensaje;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.util.ArrayList;

public interface MensajeDao { //Con esta interfaz declaramos los métodos abstractos de las funciones CRUD(Crear, leer, actualizar y borrar) para la entidad Mensaje
    public void crearMensaje(Mensaje mensaje); //Creará en la base de datos el mensaje pasado

    public ArrayList<Mensaje> getMensajesEnviados(String correo); //Devuelve el listado de mensajes envíados para el correo del usuario pasado

    public ArrayList<Mensaje> getMensajesRecibidos(String correo); //Devuelve el listado de mensajes recibidos para el correo del usuario pasado

    public void mensajeVistoDe(Mensaje mensaje); //fijará como true el atributo vistoDe del mensaje pasado

    public void mensajeVistoPara(Mensaje mensaje); //fijará como true el atributo vistoPara del mensaje pasado
}
