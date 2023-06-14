package com.ProyectoDamMPR.TimeToWork.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexContoller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "Bienvenido a TimeToWork";
    }
}
