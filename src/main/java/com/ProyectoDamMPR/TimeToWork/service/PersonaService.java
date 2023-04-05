package com.ProyectoDamMPR.TimeToWork.service;

import com.ProyectoDamMPR.TimeToWork.interfaces.PersonaInterface;
import com.ProyectoDamMPR.TimeToWork.modelo.Persona;
import com.ProyectoDamMPR.TimeToWork.modeloDAO.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonaService implements PersonaInterface {
    @Autowired
    PersonaDao dao;
    @Override
    public List<Persona> listar() {
        return dao.listar();
    }

    @Override
    public List<Map<String, Object>> listar(int id) {
        return null;
    }

    @Override
    public Persona add(Persona p) {
        return null;
    }

    @Override
    public Persona edit(Persona p) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
