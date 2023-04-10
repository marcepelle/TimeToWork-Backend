package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void crearUsuario(Usuario u) {
        //Creamos una lista de empresas para la respuesta que nos dará la query al buscar en la tabla empresa una empresa que contenga el nombre de la que corresponde el usuario
        List<Empresa> empresas = entityManager.createQuery(" FROM Empresa e WHERE e.nombreEmpresa = :nom").setParameter("nom", u.getEmpresaUsuario()).getResultList();
        u.setEmpresa_fk(empresas.get(0));
        entityManager.persist(u);
        entityManager.flush();
    }

    @Override
    public Usuario loginUsuario(CorreoContrasena correoContrasena) {
        List<Usuario> usuarios = entityManager.createQuery(" FROM Usuario u WHERE u.correoUsuario = :email").setParameter("email", correoContrasena.getCorreo()).getResultList();
        if(!usuarios.isEmpty()){
            if(correoContrasena.getPassword() == usuarios.get(0).getContrasena()){
                return usuarios.get(0);
            }
        }
        entityManager.flush();
        return null;
    }

}
