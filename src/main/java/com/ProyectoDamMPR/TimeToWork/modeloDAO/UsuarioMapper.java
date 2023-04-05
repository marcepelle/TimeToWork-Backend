package com.ProyectoDamMPR.TimeToWork.modeloDAO;

import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario usuario= new Usuario();
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNombreUsuario(rs.getString("nombreUsuario"));
        usuario.setApellidosUsuario(rs.getString("apellidosUsuario"));
        usuario.setTelefono(rs.getInt("telefono"));
        usuario.setDireccion(rs.getString("direccion"));
        usuario.setEmpresaUsuario(rs.getString("empresaUsuario"));
        usuario.setLugarTrabajo(rs.getString("lugarTrabajo"));
        usuario.setFechaNacimiento(rs.getString("fechaNacimiento"));
        usuario.setCorreoUsuario(rs.getString("correoUsuario"));
        usuario.setContrasena(rs.getString("contrasena"));
        usuario.setEsAdmin(rs.getBoolean("esAdmin"));
        return usuario;
    }
}
