package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.modelo.Persona;
import com.ProyectoDamMPR.TimeToWork.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path= "/personas")
public class PersonaControler {
    @Autowired
    PersonaService service;
    @GetMapping("/listar")
    public List<Persona>listar(){
        return service.listar();
    }

}
