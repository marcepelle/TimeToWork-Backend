package com.ProyectoDamMPR.TimeToWork.interfaces;

import com.ProyectoDamMPR.TimeToWork.modelo.Persona;

import java.util.List;
import java.util.Map;

public interface PersonaInterface {

    public List<Persona> listar();
    public List<Map<String,Object>> listar(int id);
    public Persona add(Persona p);
    public Persona edit(Persona p);
    public void delete(int id);

}
