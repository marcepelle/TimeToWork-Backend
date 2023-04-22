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

@RestController
@RequestMapping(path = "/mensajes")
public class MensajeController {
    @Autowired
    MensajeDao mensajeDao;

    @PostMapping("/crearMensaje")
    public void enviarMensaje(@RequestBody Mensaje mensaje){
        System.out.println("Creando Mensaje:......");
        mensajeDao.crearMensaje(mensaje);
    }


    @PostMapping("/obtenerRecibidos")
    public ArrayList<Mensaje> getRecibidos(@RequestBody Usuario usuario){
        System.out.println("Obteniendo Recibidos:......");
        return mensajeDao.getMensajesRecibidos(usuario);
    }

    @PostMapping("/obtenerEnviados")
    public ArrayList<Mensaje> getEnviados(@RequestBody Usuario usuario){
        System.out.println("Obteniendo Enviados:......");
        return mensajeDao.getMensajesEnviados(usuario);
    }
}
