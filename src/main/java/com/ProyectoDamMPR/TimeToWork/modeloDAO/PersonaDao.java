package com.ProyectoDamMPR.TimeToWork.modeloDAO;

import com.ProyectoDamMPR.TimeToWork.interfaces.PersonaInterface;
import com.ProyectoDamMPR.TimeToWork.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PersonaDao implements PersonaInterface {
    @Autowired
    JdbcTemplate template; // realizar el trabajo de captura de excepciones, enviar consultas a la base de datos, mapear los resultados, cerrar conexiones .etc
    @Override //devuelve como objeto cada registro de la tabla
    public List<Persona> listar() {
        List<Persona>lista=template.query("select * from personas", new PersonaMapper());
        return lista;
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
