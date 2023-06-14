package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Horario;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HorarioDao { //Con esta interfaz declaramos los métodos abstractos de las funciones CRUD(Crear, leer, actualizar y borrar) para la entidad Horario
    public void crearHorario(Horario horario);  //Creará en la base de datos el horario pasado
    public ArrayList<Horario> getHorarios(String correo); //Devuelve el listado de horarios para el correo pasado
    public int removeHorario(String correo, LocalDate fecha); //Elimina en la base de datos el horario para el correo y fecha pasado, devuelve 1 o no lo elimina y devuelve 0
    public ArrayList<Horario> obtenerFichar(String correo, LocalDate fecha); //Devuelve el horario para el correo y fecha pasado
    public void ficharEntrada(Horario horario); //Fichamos la hora de entrada para el horario pasado
    public void ficharSalida(Horario horario); //Fichamos la hora de salida para el horario pasado
}
