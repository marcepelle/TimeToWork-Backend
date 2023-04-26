package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Mensaje;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
@Transactional
public class MensajeDAOImp implements MensajeDao{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void crearMensaje(Mensaje mensaje) {
        entityManager.persist(mensaje);
        entityManager.flush();
        System.out.println("Mensaje creado");
    }

    @Override
    public ArrayList<Mensaje> getMensajesEnviados(Usuario usuario) {
        ArrayList<Mensaje> enviados = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.de = :emailde ORDER BY m.fecha DESC, m.hora DESC").setParameter("emailde", usuario.getCorreoUsuario()).getResultList();
        if (enviados.size()!=0){
            System.out.println("Enviados: " + enviados.size());
            entityManager.flush();
            return enviados;
        }
        entityManager.flush();
        return new ArrayList<Mensaje>();
    }

    @Override
    public ArrayList<Mensaje> getMensajesRecibidos(Usuario usuario) {
        ArrayList<Mensaje> recibidos = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.para = :emailpara ORDER BY m.fecha DESC, m.hora DESC").setParameter("emailpara", usuario.getCorreoUsuario()).getResultList();
        if (recibidos.size()!=0){
            System.out.println("Recibidos: " + recibidos.size());
            entityManager.flush();
            return recibidos;
        }
        entityManager.flush();
        return new ArrayList<Mensaje>();
    }

    public void mensajeVistoDe(Mensaje mensaje){
       ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.idMensaje = :id").setParameter("id", mensaje.getIdMensaje()).getResultList();
        if(mensajes.size()!=0){
            mensajes.get(0).setVistoDe(true);
            entityManager.merge(mensajes.get(0));
            System.out.println("Mensaje visto de");
        }else{
            System.out.println("Mensaje no encontrado");
        }
        entityManager.flush();
    }

    public void mensajeVistoPara(Mensaje mensaje){
        ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.idMensaje = :id").setParameter("id", mensaje.getIdMensaje()).getResultList();
        if(mensajes.size()!=0){
            mensajes.get(0).setVistoPara(true);
            entityManager.merge(mensajes.get(0));
            System.out.println("Mensaje visto para");
        }else{
            System.out.println("Mensaje no encontrado");
        }
        entityManager.flush();
    }
}
