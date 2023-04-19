package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.dao.EmpresaDAO;
import com.ProyectoDamMPR.TimeToWork.dao.UsuarioDAO;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        System.out.println("Coreo y contrasena: " + correoContrasena.toString());
        Usuario usuarioLogged = usuarioDAO.loginUsuario(correoContrasena);

        return usuarioLogged;
    }
    @PostMapping("/obtenerUsuario")
    public Usuario obtenerUsuario(@RequestBody CorreoContrasena correoContrasena){
        return usuarioDAO.getUsuario(correoContrasena);
    }
    @PostMapping ("/listarUsuarios")
    public ArrayList<Usuario> listarUsuarios(@RequestBody Usuario usuario){
        return usuarioDAO.getUsuarios(usuario);
    }
    @PostMapping("/actualizarUsuario")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioActualizado = usuarioDAO.updateUsuario(usuario);
        System.out.println("");
        return usuarioActualizado;
    }

    @PostMapping ("/borrarUsuario")
    public void borrarUusario(@RequestBody Usuario usuario){
        int res = usuarioDAO.RemoveUsuario(usuario);
        System.out.println("Usuario: " + usuario.getNombreUsuario() + " eliminado: " + res);
    }
}
