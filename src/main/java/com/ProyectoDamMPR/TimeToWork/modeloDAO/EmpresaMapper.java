package com.ProyectoDamMPR.TimeToWork.modeloDAO;

import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(rs.getInt("idEmpresa"));
        empresa.setCif(rs.getString("CIF"));
        empresa.setNombreEmpresa("nombreEmpresa");
        empresa.setTelefono(rs.getInt("telefono"));
        empresa.setNombreadmin(rs.getString("nombreadmin"));
        empresa.setPais(rs.getString("pais"));
        empresa.setProvincia(rs.getString("provincia"));
        empresa.setCiudad(rs.getString("ciudad"));
        return empresa;
    }
}
