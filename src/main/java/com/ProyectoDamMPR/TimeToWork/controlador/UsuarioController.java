package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import com.ProyectoDamMPR.TimeToWork.modeloDAO.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioDao usuarioDao;

    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestBody Usuario usuario){
        int respuesta= usuarioDao.crearUsuario(usuario);
        if(respuesta==0){
            System.out.println("Cuenta no registrada");
            //return "Cuenta no registrada";

        }
        System.out.println("Cuenta registrada");
        //return "Cuenta registrada";
    }
    @PostMapping("/crearEmpresa")
    public String crearEmpresa(@RequestBody Empresa empresa){
        int respuesta= usuarioDao.crearEmpresaUsuario(empresa);
        if(respuesta==0){
            return "Empresa no registrada";
        }
        return "Empresa registrada";
    }
}
