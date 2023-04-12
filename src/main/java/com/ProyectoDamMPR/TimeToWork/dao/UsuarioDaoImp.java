package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDAO {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Usuario loginUsuario(CorreoContrasena correoContrasena) {
        System.out.println("contrasena DAO: " + correoContrasena.getPassword());
        List<Usuario> usuarios = entityManager.createQuery(" FROM Usuario u WHERE u.correoUsuario = :email").setParameter("email", correoContrasena.getCorreo()).getResultList();
        List<Empresa> empresas = entityManager.createQuery(" FROM Empresa e WHERE e.nombreEmpresa = :nom").setParameter("nom", usuarios.get(0).getEmpresaUsuario()).getResultList();
        System.out.println("Empresas Vacio: " + empresas.isEmpty());
        usuarios.get(0).setEmpresa_fk(empresas.get(0));
        System.out.println("Usuarios Vacio: " + usuarios.isEmpty());
        if(!usuarios.isEmpty()){
            System.out.println("No esta vacío");
            if(correoContrasena.getPassword().equals(usuarios.get(0).getContrasena())){
                System.out.println("Dentro");
                entityManager.flush();
                return usuarios.get(0);
            }
        }
        entityManager.flush();
        return null;
    }

    @Override
    public void crearUsuario(Usuario u) {
        //Creamos una lista de empresas para la respuesta que nos dará la query al buscar en la tabla empresa una empresa que contenga el nombre de la que corresponde el usuario
        List<Empresa> empresas = entityManager.createQuery(" FROM Empresa e WHERE e.nombreEmpresa = :nom").setParameter("nom", u.getEmpresaUsuario()).getResultList();
        u.setEmpresa_fk(empresas.get(0));
        entityManager.persist(u);
        entityManager.flush();
    }

    public ArrayList<Usuario> getUsuarios(Usuario usuario){
        List<Empresa> empresaUser = entityManager.createQuery("select e.idEmpresa FROM Empresa e WHERE e.nombreEmpresa = :nom").setParameter("nom", usuario.getEmpresaUsuario()).getResultList();
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery("FROM Usuario u WHERE u.empresaUsuario = :emp").setParameter("emp", usuario.getEmpresaUsuario()).getResultList();
        System.out.println("Obteniendo lista : " + usuarios.size() + usuarios.get(0).getNombreUsuario());
        /*Iterator<Usuario> iteradorListU = usuarios.iterator();
        while(iteradorListU.hasNext()){
            iteradorListU.next().setEmpresa_fk(empresaUser.get(0));
        }*/
        return usuarios;
    }
    public Usuario updateUsuario(Usuario usuario){
        System.out.println("actualizando");
        Usuario usuarioActualizado = entityManager.merge(usuario);
        System.out.println(usuarioActualizado.toString());
        entityManager.flush();
        return usuarioActualizado;
    }

}
