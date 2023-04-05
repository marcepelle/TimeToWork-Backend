package com.ProyectoDamMPR.TimeToWork.modeloDAO;

import com.ProyectoDamMPR.TimeToWork.interfaces.UsuarioInterface;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UsuarioDao implements UsuarioInterface {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int crearUsuario(Usuario u) {
        String sqlStatement = "insert into usuario(idUsuario, nombreUsuario, apellidosUsuario, telefono, direccion, empresaUsuario, lugarTrabajo, fechaNacimiento, correoUsuario, contrasena, esAdmin) values(?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sqlStatement, u.getIdUsuario(), u.getNombreUsuario(), u.getApellidosUsuario(), u.getTelefono(),u.getDireccion(), u.getEmpresaUsuario(), u.getLugarTrabajo(), u.getFechaNacimiento(), u.getCorreoUsuario(), u.getContrasena(), u.isEsAdmin());
    }

    @Override
    public int crearEmpresaUsuario(Empresa empresa) {
        String sqlStatement = "insert into empresa(CIF, nombreEmpresa, telefono, nombreAdmin, pais, provincia, ciudad) values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sqlStatement, empresa.getCIF(), empresa.getNombreEmpresa(), empresa.getTelefono(), empresa.getNombreAdmin(), empresa.getPais(), empresa.getProvincia(), empresa.getCiudad());
    }

    @Override
    public Usuario loginUsuario(String correoUsuario, String contrasena) {
        String sqlStatement = "select * from usuario where email=?";
        List<Usuario> usuarioList = jdbcTemplate.query(sqlStatement, new UsuarioMapper(), new Object[]{correoUsuario});
        if(usuarioList.isEmpty()||usuarioList.get(0).getContrasena()!=contrasena){
            return null;
        }
        return usuarioList.get(0);
    }
}
