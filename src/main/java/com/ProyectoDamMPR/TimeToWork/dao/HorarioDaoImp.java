package com.ProyectoDamMPR.TimeToWork.dao;
;
import com.ProyectoDamMPR.TimeToWork.modelo.Horario;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Transactional
public class HorarioDaoImp implements  HorarioDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void crearHorario(Horario horario) {
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .getResultList();
        if(horarios.size() == 0) {
            entityManager.persist(horario);
            entityManager.flush();
            System.out.println("Horario creado");
        }else{
            System.out.println("Horario no creado ya existe para el usuario y la fecha indicada");
        }
    }

    @Override
    public ArrayList<Horario> getHorarios(Usuario usuario) {
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.correoEmpleado = :email").setParameter("email", usuario.getCorreoUsuario()).getResultList();
        System.out.println("Obteniendo lista tamaño: " + horarios.size());
        entityManager.flush();
        return horarios;
    }

    @Override
    public Horario updateHorario(Horario horario) {
        return null;
    }

    @Override
    public int removeHorario(Horario horario) {
        int res = entityManager.createQuery("DELETE Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .executeUpdate();
        entityManager.flush();
        return res;
    }

    public ArrayList<Horario> obtenerFichar(Horario horario){
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .getResultList();
        if(horarios.size()!=0) {
            System.out.println("Horario conseguido: " + horarios.get(0).toString());
            entityManager.flush();
            return horarios;
        }
        System.out.println("Horario no conseguido");
        entityManager.flush();
        return new ArrayList<Horario>();
    }

    public void ficharEntrada(Horario horario){
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .getResultList();
        System.out.println("Horario conseguido: " + horarios.get(0).toString());
        if(horarios.get(0).getFichaEntrada()==null) {
            System.out.println("fichar entrada dentro para: " + horario.toString());
             entityManager.createQuery("UPDATE Horario h SET h.fichaEntrada = :entrada WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                    .setParameter("entrada", horario.getFichaEntrada())
                    .setParameter("fecha", horario.getFecha())
                    .setParameter("email", horario.getCorreoEmpleado())
                    .executeUpdate();
        }else {
            System.out.println("No fichar entrada");
        }
    }
    public void ficharSalida(Horario horario){
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .getResultList();
        if(horarios.get(0).getFichaSalida()==null) {
            System.out.println("fichar salida dentro para: " + horario.toString());
          entityManager.createQuery("UPDATE Horario h SET h.fichaSalida = :salida WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                    .setParameter("salida", horario.getFichaSalida())
                    .setParameter("fecha", horario.getFecha())
                    .setParameter("email", horario.getCorreoEmpleado())
                    .executeUpdate();
          entityManager.flush();
        }else {
            System.out.println("No fichar salida");
        }
    }

}
