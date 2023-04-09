package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.dao.EmpresaDAO;
import com.ProyectoDamMPR.TimeToWork.dao.UsuarioDAO;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/usuarios")
public class UsuarioController {
    @Autowired
    EmpresaDAO empresaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;

    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestBody Usuario usuario){
                usuarioDAO.crearUsuario(usuario);
    }

    @PostMapping("/crearEmpresa")
    public void crearEmpresa(@RequestBody Empresa empresa){
                empresaDAO.crearEmpresaUsuario(empresa);
    }

    @PostMapping ("/loginUsuario")
    public Usuario iniciarSesion(@RequestBody CorreoContrasena correoContrasena) {
        Usuario usuarioLogged = usuarioDAO.loginUsuario(correoContrasena);
        return usuarioLogged;
    }
}
