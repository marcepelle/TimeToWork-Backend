package com.ProyectoDamMPR.TimeToWork.modeloDAO;

import com.ProyectoDamMPR.TimeToWork.interfaces.UsuarioInterface;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
@Transactional
@Repository
public class UsuarioDao implements UsuarioInterface {

    @Autowired
    EntityManager entityManager;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int crearUsuario(Usuario u) {
        entityManager.flush();
        String selStatement = "SELECT * FROM empresa";
        List<Empresa> empresa1 = jdbcTemplate.query(selStatement, new EmpresaMapper());
        int posEmpresa= 0;
        Iterator<Empresa> empresaIterator = empresa1.listIterator();
        while(empresaIterator.hasNext()){
            Empresa empresaIter= empresaIterator.next();
            if (empresaIter.getNombreEmpresa()==u.getEmpresaUsuario()){
                break;
            }
            posEmpresa++;
        }
        System.out.println("Tamaño lista: " + empresa1.size() + "Posición Emp: " + posEmpresa);
        System.out.println(selStatement);
        String sqlStatement = "insert into usuario(nombreUsuario, apellidosUsuario, telefono, direccion, empresaUsuario, lugarTrabajo, fechaNacimiento, correoUsuario, contrasena, esAdmin, idEmpresa_fk) values(?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sqlStatement, u.getNombreUsuario(), u.getApellidosUsuario(), u.getTelefono(),u.getDireccion(), u.getEmpresaUsuario(), u.getLugarTrabajo(), u.getFechaNacimiento(), u.getCorreoUsuario(), u.getContrasena(), u.isEsAdmin(),empresa1.get(posEmpresa).getIdEmpresa());
    }

    @Override
    public int crearEmpresaUsuario(Empresa empresa) {
        String sqlStatement = "insert into empresa(CIF, nombreEmpresa, telefono, nombreadmin, pais, provincia, ciudad) values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sqlStatement, empresa.getCif(), empresa.getNombreEmpresa(), empresa.getTelefono(), empresa.getNombreadmin(), empresa.getPais(), empresa.getProvincia(), empresa.getCiudad());
    }

    @Override
    public Usuario loginUsuario(String correoUsuario, String contrasena) {
        String sqlStatement = "select * from usuario where email = ?";
        List<Usuario> usuarioList = jdbcTemplate.query(sqlStatement, new UsuarioMapper(), new Object[]{correoUsuario});
        if(usuarioList.isEmpty()||usuarioList.get(0).getContrasena()!=contrasena){
            return null;
        }
        return usuarioList.get(0);
    }
}
