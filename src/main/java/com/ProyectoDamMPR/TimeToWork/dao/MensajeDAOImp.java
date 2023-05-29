package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Mensaje;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository //Declaramos que la clase será un componente encargado de resolver el acceso y la gestión de los datos en la BBDD para la entidad Mensaje, es la capa de persistencia
@Transactional //Declaramos el comportamiento de los métodos de la clase en referencia a las transacciones, de manera predeterminada es REQUIRED que indica que si existe una transacción en curso se usará esa y si no creará una nueva
public class MensajeDAOImp implements MensajeDao{ //implementamos la interfaz MensajeDao
    @PersistenceContext //Inyecta automaticamente una referencia apropiada del EntityManager
    EntityManager entityManager; //Creamos un objeto EntityManager para establecer una conexión transaccional con la BBDD y gestionar las entidades
    @Override
    public void crearMensaje(Mensaje mensaje) {  //Creará en la base de datos el mensaje pasado
        entityManager.persist(mensaje); //hacemos que persista el objeto Mensaje en la base de datos
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        System.out.println("Mensaje creado");
    }

    @Override
    public ArrayList<Mensaje> getMensajesEnviados(Usuario usuario) { //Devuelve el listado de mensajes envíados para el usuario pasado
        ArrayList<Mensaje> enviados = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.de = :emailde ORDER BY m.fecha DESC, m.hora DESC")
                .setParameter("emailde", usuario.getCorreoUsuario())
                .getResultList(); // La consulta nos devolverá un listado de mensajes para los registros que contengan en el campo "de" el correo del usuario pasado, estarán ordenados por fecha y hora en orden descendente
        if (enviados.size()!=0){ //Si el listado no esta vacío
            System.out.println("Enviados: " + enviados.size());
            entityManager.flush(); //sincronizamos la conexión con la base de datos
            return enviados; //Devolvemos el listado de envíados
        }
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return new ArrayList<Mensaje>(); //En caso contrario devolvemos el listado vacío
    }

    @Override
    public ArrayList<Mensaje> getMensajesRecibidos(Usuario usuario) { //Devuelve el listado de mensajes recibidos para el usuario pasado
        ArrayList<Mensaje> recibidos = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.para = :emailpara ORDER BY m.fecha DESC, m.hora DESC")
                .setParameter("emailpara", usuario.getCorreoUsuario())
                .getResultList(); // La consulta nos devolverá un listado de mensajes para los registros que contengan en el campo "para" el correo del usuario pasado, estarán ordenados por fecha y hora en orden descendente
        if (recibidos.size()!=0){ //Si el listado no esta vacío
            System.out.println("Recibidos: " + recibidos.size());
            entityManager.flush(); //sincronizamos la conexión con la base de datos
            return recibidos; //Devolvemos el listado de recibidos
        }
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return new ArrayList<Mensaje>(); //En caso contrario devolvemos el listado vacío
    }

    public void mensajeVistoDe(Mensaje mensaje){ //fijará como true el atributo vistoDe del mensaje pasado
       ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.idMensaje = :id")
               .setParameter("id", mensaje.getIdMensaje())
               .getResultList(); //La consulta nos devolverá un listado de mensajes para los registros que contengan en el campo idMensaje el id del mensaje pasado, debería devolver un mensaje o ninguno
        if(mensajes.size()!=0){ //Si el listado no esta vacío
            mensajes.get(0).setVistoDe(true); //fijamos el atributo vistoPara como true
            entityManager.merge(mensajes.get(0)); //Merge combina los valores nuevos con los antiguos para actualizar el objeto mensaje pasado
            System.out.println("Mensaje visto de fijado como true");
        }else{
            System.out.println("Mensaje no encontrado");
        }
        entityManager.flush(); //sincronizamos la conexión con la base de datos
    }

    public void mensajeVistoPara(Mensaje mensaje){ //fijará como true el atributo vistoPara del mensaje pasado
        ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) entityManager.createQuery("FROM Mensaje m WHERE m.idMensaje = :id")
                .setParameter("id", mensaje.getIdMensaje())
                .getResultList(); //La consulta nos devolverá un listado de mensajes para los registros que contengan en el campo idMensaje el id del mensaje pasado, debería devolver un mensaje o ninguno
        if(mensajes.size()!=0){ //Si el listado no esta vacío
            mensajes.get(0).setVistoPara(true); //fijamos el atributo vistoPara como true
            entityManager.merge(mensajes.get(0));  //Merge combina los valores nuevos con los antiguos para actualizar el objeto mensaje pasado
            System.out.println("Mensaje visto para fijado como true");
        }else{
            System.out.println("Mensaje no encontrado");
        }
        entityManager.flush(); //sincronizamos la conexión con la base de datos
    }
}
