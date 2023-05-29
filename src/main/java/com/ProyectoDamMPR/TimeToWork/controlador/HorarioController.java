package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.dao.HorarioDao;
import com.ProyectoDamMPR.TimeToWork.modelo.Horario;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //Declaramos que la clase es un componente Controller que recibirá y responderá peticiones http
@RequestMapping(path= "/horarios") //Declaramos la ruta raíz del Controller
public class HorarioController {
    @Autowired //Autowired se encarga del control de inyección de dependencias, crea la instancia del objeto e inyecta la dependencia
    HorarioDao horarioDao;

    @PostMapping("/crearHorario") //A través de un método Post en la ruta declarada se creará el horario que se envío en la petición
    private void crearHorario(@RequestBody Horario horario){ //Con RequestBody deserializamos un objeto Horario a partir del cuerpo de la petición
        horarioDao.crearHorario(horario);
    System.out.println("En creación de horarios");
    }

    @PostMapping("/getHorarios")  //A través de un método Post en la ruta declarada se devuelve un listado de horarios para el usuario pasado en la petición
    private ArrayList<Horario> getHorarios(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        System.out.println("En Obtención de horarios");
        return horarioDao.getHorarios(usuario);
    }

    @PostMapping("/eliminarHorarios")  //A través de un método Post en la ruta declarada se elimina el horario pasado en la petición
    private void eliminarHorarios(@RequestBody Horario horario){ //Con RequestBody deserializamos un objeto horario a partir del cuerpo de la petición
        int res = horarioDao.removeHorario(horario); //eliminamos el horario y obtenemos la respuesta de si se ha eliminado o no en un entero
        if (res == 1){ //si la respuesta es 1 entonces el usuario se ha eliminado
            System.out.println("Horario borrado para fecha: " + horario.getFecha() + " correo: " + horario.getCorreoEmpleado());
        }
        else { //en caso contrario, el resultado es 0 y quiere decir que no se ha eliminado
            System.out.println("Horario no borrado");
        }
    }

    @PostMapping("/ficharEntrada") //A través de un método Post en la ruta declarada se ficha la hora de entrada para el horario pasado en la petición
    private void ficharEntrada(@RequestBody Horario horario){ //Con RequestBody deserializamos un objeto horario a partir del cuerpo de la petición
        System.out.println("En fichar entrada");
        horarioDao.ficharEntrada(horario);
    }

    @PostMapping("/ficharSalida") //A través de un método Post en la ruta declarada se ficha la hora de la salida para el horario pasado en la petición
    private void ficharSalida(@RequestBody Horario horario){ //Con RequestBody deserializamos un objeto horario a partir del cuerpo de la petición
        System.out.println("En fichar salida");
        horarioDao.ficharSalida(horario);
    }
    @PostMapping("/obtenerFichar") //A través de un método Post en la ruta declarada se obtienen los horario para la fecha del horario pasado en la petición
    private ArrayList<Horario> obtenerHorarioFichar (@RequestBody Horario horario){  //A través de un método Post en la ruta declarada se  de la salida para el horario pasado en la petición
        System.out.println("En obtener horario");
        return horarioDao.obtenerFichar(horario);
    }

}
