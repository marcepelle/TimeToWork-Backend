package com.ProyectoDamMPR.TimeToWork.modeloDAO;

import com.ProyectoDamMPR.TimeToWork.modelo.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<Persona> {

    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
        Persona persona = new Persona();
        persona.setId(rs.getInt("id"));
        persona.setNombre(rs.getString("nombre"));
        persona.setApellido(rs.getString("apellido"));
        return persona;
    }
}
