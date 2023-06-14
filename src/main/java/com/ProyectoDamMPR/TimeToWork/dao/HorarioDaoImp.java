package com.ProyectoDamMPR.TimeToWork.dao;
;
import com.ProyectoDamMPR.TimeToWork.modelo.Horario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository //Declaramos que la clase será un componente encargado de resolver el acceso y la gestión de los datos en la BBDD para la entidad Horario, es la capa de persistencia
@Transactional //Declaramos el comportamiento de los métodos de la clase en referencia a las transacciones, de manera predeterminada es REQUIRED que indica que si existe una transacción en curso se usará esa y si no creará una nueva
public class HorarioDaoImp implements  HorarioDao{
    @PersistenceContext //Inyecta automaticamente una referencia apropiada del EntityManager
    EntityManager entityManager; //Creamos un objeto EntityManager para establecer una conexión transaccional con la BBDD y gestionar las entidades


    @Override
    public void crearHorario(Horario horario) {  //Creará en la base de datos el horario pasado
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .getResultList(); // La consulta nos devolverá un listado de horarios para los registros que contengan la fecha y el correo del usuario del horario pasado
        if(horarios.size() == 0) { //si no existe un horario para la fecha y correo pasado
            entityManager.persist(horario); //hacemos que persista el objeto Horario en la base de datos
            entityManager.flush(); //sincronizamos la conexión con la base de datos
            System.out.println("Horario creado");
        }else{
            System.out.println("Horario no creado ya existe para el usuario y la fecha indicada");
        }
    }

    @Override
    public ArrayList<Horario> getHorarios(String correo) { //Devuelve el listado de horarios para el correo pasado
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.correoEmpleado = :email")
                .setParameter("email", correo)
                .getResultList(); // La consulta nos devolverá un listado de horarios para los registros que contengan el correo del usuario pasado
        System.out.println("Obteniendo lista tamaño: " + horarios.size());
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return horarios; //Devolvemos el listado de horarios
    }

    @Override
    public int removeHorario(String correo, LocalDate fecha) { //Elimina en la base de datos el horario para el correo y fecha pasado, devuelve 1 o no lo elimina y devuelve 0
        int res = entityManager.createQuery("DELETE Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", correo)
                .setParameter("fecha", fecha)
                .executeUpdate(); //Ejecutamos el borrado del registro donde contenga la fecha y el correo del usuario del horario pasado
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return res; //devolvemos la respuesta en un entero de si se elimino o no el horario
    }

    public ArrayList<Horario> obtenerFichar(String correo, LocalDate fecha){ //Devuelve el listado de horarios para la fecha y el correo del usuario del horario pasado
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", correo)
                .setParameter("fecha", fecha)
                .getResultList(); // La consulta nos devolverá un listado de horarios para los registros que contengan la fecha y el correo del usuario del horario pasado
        if(horarios.size()!=0) { //si el listado no está vacío
            System.out.println("Horario conseguido: " + horarios.get(0).toString());
            entityManager.flush();  //sincronizamos la conexión con la base de datos
            return horarios; //devolvemos el listado de horarios
        }
        System.out.println("Horario no conseguido");
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return new ArrayList<Horario>(); //En caso contrario devolvemos el listado vacío
    }

    public void ficharEntrada(Horario horario){ //Fichamos la hora de entrada para el horario pasado
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .getResultList(); // La consulta nos devolverá un listado de horarios para los registros que contengan la fecha y el correo del usuario del horario pasado
        System.out.println("Horario conseguido: " + horarios.get(0).toString());
        if(horarios.get(0).getFichaEntrada()==null) { //si no se ha fichado la hora de entrada para el horario buscado
            System.out.println("fichar entrada dentro para: " + horario.toString());
             entityManager.createQuery("UPDATE Horario h SET h.fichaEntrada = :entrada WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                    .setParameter("entrada", horario.getFichaEntrada())
                    .setParameter("fecha", horario.getFecha())
                    .setParameter("email", horario.getCorreoEmpleado())
                    .executeUpdate(); //actualizamos el campo fichaEntrada con la hora de entrada del horario pasado donde el registro contiene la fecha y el correo del usuario del horario pasado
            entityManager.flush(); //sincronizamos la conexión con la base de datos
        }else {
            System.out.println("No fichar entrada");
        }
    }
    public void ficharSalida(Horario horario){  //Fichamos la hora de salida para el horario pasado
        ArrayList<Horario> horarios = (ArrayList<Horario>) entityManager.createQuery("FROM Horario h WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                .setParameter("email", horario.getCorreoEmpleado())
                .setParameter("fecha", horario.getFecha())
                .getResultList(); // La consulta nos devolverá un listado de horarios para los registros que contengan la fecha y el correo del usuario del horario pasado
        if(horarios.get(0).getFichaSalida()==null) { //si no se ha fichado la hora de salida para el horario buscado
            System.out.println("fichar salida dentro para: " + horario.toString());
          entityManager.createQuery("UPDATE Horario h SET h.fichaSalida = :salida WHERE h.fecha = :fecha AND h.correoEmpleado = :email")
                    .setParameter("salida", horario.getFichaSalida())
                    .setParameter("fecha", horario.getFecha())
                    .setParameter("email", horario.getCorreoEmpleado())
                    .executeUpdate(); //actualizamos el campo fichaSalida con la hora de salida del horario pasado donde el registro contiene la fecha y el correo del usuario del horario pasado
          entityManager.flush(); //sincronizamos la conexión con la base de datos
        }else {
            System.out.println("No fichar salida");
        }
    }

}
