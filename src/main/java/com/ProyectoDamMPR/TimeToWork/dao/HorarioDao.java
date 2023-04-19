package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Horario;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.util.ArrayList;

public interface HorarioDao {
    public void crearHorario(Horario horario);
    public ArrayList<Horario> getHorarios(Usuario usuario);
    public Horario updateHorario(Horario horario);
    public int removeHorario(Horario horario);
    public ArrayList<Horario> obtenerFichar(Horario horario);
    public void ficharEntrada(Horario horario);
    public void ficharSalida(Horario horario);
}
