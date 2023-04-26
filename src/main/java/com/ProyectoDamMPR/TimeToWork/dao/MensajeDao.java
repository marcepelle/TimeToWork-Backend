package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Mensaje;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;

import java.util.ArrayList;

public interface MensajeDao {
    public void crearMensaje(Mensaje mensaje);

    public ArrayList<Mensaje> getMensajesEnviados(Usuario usuario);

    public ArrayList<Mensaje> getMensajesRecibidos(Usuario usuario);

    public void mensajeVistoDe(Mensaje mensaje);

    public void mensajeVistoPara(Mensaje mensaje);
}
