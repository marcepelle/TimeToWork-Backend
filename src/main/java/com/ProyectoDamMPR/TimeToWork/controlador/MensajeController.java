package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.dao.MensajeDao;
import com.ProyectoDamMPR.TimeToWork.modelo.Mensaje;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController //Declaramos que la clase es un componente Controller que recibirá y responderá peticiones http
@RequestMapping(path = "/mensajes") //Declaramos la ruta raíz del Controller
public class MensajeController {
    @Autowired  //Autowired se encarga del control de inyección de dependencias, crea la instancia del objeto e inyecta la dependencia
    MensajeDao mensajeDao;

    @PostMapping("/crearMensaje") //A través de un método Post en la ruta declarada se creará el mensaje que se envío en la petición
    public void enviarMensaje(@RequestBody Mensaje mensaje){ //Con RequestBody deserializamos un objeto mensaje a partir del cuerpo de la petición
        System.out.println("Creando Mensaje:......");
        mensajeDao.crearMensaje(mensaje);
    }


    @PostMapping("/obtenerRecibidos") //A través de un método Post en la ruta declarada se devuelve un listado de mensajes recibidos para el usuario pasado en la petición
    public ArrayList<Mensaje> getRecibidos(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto usuario a partir del cuerpo de la petición
        System.out.println("Obteniendo Recibidos:......");
        return mensajeDao.getMensajesRecibidos(usuario);
    }

    @PostMapping("/obtenerEnviados") //A través de un método Post en la ruta declarada se devuelve un listado de mensajes envíados para el usuario pasado en la petición
    public ArrayList<Mensaje> getEnviados(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto usuario a partir del cuerpo de la petición
        System.out.println("Obteniendo Enviados:......");
        return mensajeDao.getMensajesEnviados(usuario);
    }

    @PostMapping("/mensajeVistoDe")  //A través de un método Post en la ruta declarada se fijará como true el atributo vistoDe del mensaje que se envío en la petición
    public void vistoDe(@RequestBody Mensaje mensaje){ //Con RequestBody deserializamos un objeto mensaje a partir del cuerpo de la petición
        mensajeDao.mensajeVistoDe(mensaje);
       System.out.println("Dentro de mensaje visto De:" + mensaje.getDe());
    }

    @PostMapping("/mensajeVistoPara") //A través de un método Post en la ruta declarada se fijará como true el atributo vistoPara del mensaje que se envío en la petición
    public void vistoPara(@RequestBody Mensaje mensaje){  //Con RequestBody deserializamos un objeto mensaje a partir del cuerpo de la petición
        mensajeDao.mensajeVistoPara(mensaje);
        System.out.println("Dentro de mensaje visto Para" + mensaje.getPara());
    }
}
