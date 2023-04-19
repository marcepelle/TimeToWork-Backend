package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.dao.HorarioDao;
import com.ProyectoDamMPR.TimeToWork.modelo.Horario;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path= "/horarios")
public class HorarioController {
    @Autowired
    HorarioDao horarioDao;

    @PostMapping("/crearHorario")
    private void crearHorario(@RequestBody Horario horario){
        horarioDao.crearHorario(horario);
    System.out.println("En creación de horarios");
    }

    @PostMapping("/getHorarios")
    private ArrayList<Horario> getHorarios(@RequestBody Usuario usuario){
        System.out.println("En Obtención de horarios");
        return horarioDao.getHorarios(usuario);
    }

    @PostMapping("/eliminarHorarios")
    private void eliminarHorarios(@RequestBody Horario horario){
        int res = horarioDao.removeHorario(horario);
        if (res == 1){
            System.out.println("Horario borrado para fecha: " + horario.getFecha() + " correo: " + horario.getCorreoEmpleado());
        }
        else {
            System.out.println("Horario no borrado");
        }
    }

    @PostMapping("/ficharEntrada")
    private void ficharEntrada(@RequestBody Horario horario){
        System.out.println("En fichar entrada");
        horarioDao.ficharEntrada(horario);
    }

    @PostMapping("/ficharSalida")
    private void ficharSalida(@RequestBody Horario horario){
        System.out.println("En fichar salida");
        horarioDao.ficharSalida(horario);
    }
    @PostMapping("/obtenerFichar")
    private ArrayList<Horario> obtenerHorarioFichar (@RequestBody Horario horario){
        System.out.println("En obtener horario fichar");
        return horarioDao.obtenerFichar(horario);
    }

}
