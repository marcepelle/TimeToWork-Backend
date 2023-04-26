package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDAO {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Usuario loginUsuario(CorreoContrasena correoContrasena) {
        List<Usuario> usuarios = entityManager.createQuery(" FROM Usuario u WHERE u.correoUsuario = :email").setParameter("email", correoContrasena.getCorreo()).getResultList();
        System.out.println("Usuarios Vacio: " + usuarios.isEmpty());
        String hashCorreoContrasena = obtenerHash(correoContrasena.getPassword());
        System.out.println("contrasena DAO: " + hashCorreoContrasena);
        if(!usuarios.isEmpty()){
            List<Empresa> empresas = entityManager.createQuery(" FROM Empresa e WHERE e.nombreEmpresa = :nom").setParameter("nom", usuarios.get(0).getEmpresaUsuario()).getResultList();
            System.out.println("Empresas Vacio: " + empresas.isEmpty());
            usuarios.get(0).setEmpresa_fk(empresas.get(0));
            System.out.println("No esta vacío");
            if(hashCorreoContrasena.equals(usuarios.get(0).getContrasena())){
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
        String hashContrasena = obtenerHash(u.getContrasena());
        u.setContrasena(hashContrasena);
        entityManager.persist(u);
        entityManager.flush();
        System.out.println("Usuario creado");
    }

    private String obtenerHash(String contrasena) {

        String hashContrasena = null;
        try {
            MessageDigest hashear = MessageDigest.getInstance("SHA-256");
            hashear.reset();
            hashear.update(contrasena.getBytes("utf8"));
            hashContrasena = String.format("%064x", new BigInteger(1, hashear.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashContrasena;
    }

    public Usuario getUsuario(CorreoContrasena correoContrasena){
        System.out.println("En obtencion de Usuario");
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery(" FROM Usuario u WHERE u.correoUsuario = :email")
                .setParameter("email", correoContrasena.getCorreo())
                .getResultList();
        if (usuarios.size()!=0){
            System.out.println("Usuario: " + usuarios.get(0));
            return usuarios.get(0);
        }
        return new Usuario();
    }

    public ArrayList<Usuario> getUsuarios(Usuario usuario){
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery("FROM Usuario u WHERE u.empresaUsuario = :emp").setParameter("emp", usuario.getEmpresaUsuario()).getResultList();
        System.out.println("Obteniendo lista : " + usuarios.size() + usuarios.get(0).getNombreUsuario());
        return usuarios;
    }
    public Usuario updateUsuario(Usuario usuario){
        System.out.println("actualizando");
        Usuario usuarioActualizado = entityManager.merge(usuario);
        System.out.println(usuarioActualizado.toString());
        entityManager.flush();
        return usuarioActualizado;
    }

    public int RemoveUsuario(Usuario usuario){
        System.out.println("Eliminando " + usuario.getNombreUsuario());
        int resRemove = entityManager.createQuery("delete Usuario u where u.idUsuario = :id").setParameter("id", usuario.getIdUsuario()).executeUpdate();
        entityManager.flush();
        return resRemove;
    }
}
