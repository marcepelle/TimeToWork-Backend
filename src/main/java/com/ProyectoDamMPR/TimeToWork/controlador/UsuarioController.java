package com.ProyectoDamMPR.TimeToWork.controlador;

import com.ProyectoDamMPR.TimeToWork.dao.EmpresaDAO;
import com.ProyectoDamMPR.TimeToWork.dao.UsuarioDAO;
import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //Declaramos que la clase es un componente Controller que recibirá y responderá peticiones http
@RequestMapping(path= "/usuarios") //Declaramos la ruta raíz del Controller
public class UsuarioController {
    @Autowired //Autowired se encarga del control de inyección de dependencias, crea la instancia del objeto e inyecta la dependencia
    EmpresaDAO empresaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;

    @PostMapping("/crearUsuario") //A través de un método Post en la ruta declarada se creará el usuario que se envío en la petición
    public void crearUsuario(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        usuarioDAO.crearUsuario(usuario);
    }
    @PostMapping("/crearEmpresa") //A través de un método Post en la ruta declarada se creará la Empresa que se envío en la petición
    public void crearEmpresa(@RequestBody Empresa empresa){ //Con RequestBody deserializamos un objeto Empresa a partir del cuerpo de la petición
        empresaDAO.crearEmpresaUsuario(empresa);
    }
    @PostMapping ("/loginUsuario") //A través de un método Post en la ruta declarada se devolverá el Usuario para la sesión si para el objeto correoContrasena que se envío en la petición los datos existen en la base de datos y son correctos
    public Usuario iniciarSesion(@RequestBody CorreoContrasena correoContrasena) { //Con RequestBody deserializamos un objeto CorreoContrasena a partir del cuerpo de la petición
        System.out.println("Coreo y contrasena: " + correoContrasena.toString());
        Usuario usuarioLogged = usuarioDAO.loginUsuario(correoContrasena);
        return usuarioLogged;
    }
    @PostMapping("/obtenerUsuario") //A través de un método Post en la ruta declarada se devolverá un Usuario si para el objeto correoContrasena que se envío en la petición los datos existen en la base de datos y son correctos
    public Usuario obtenerUsuario(@RequestBody CorreoContrasena correoContrasena){ //Con RequestBody deserializamos un objeto CorreoContrasena a partir del cuerpo de la petición
        return usuarioDAO.getUsuario(correoContrasena);
    }
    @PostMapping ("/listarUsuarios") //A través de un método Post en la ruta declarada se devuelve un listado de usuarios para el usuario pasado en la petición
    public ArrayList<Usuario> listarUsuarios(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        return usuarioDAO.getUsuarios(usuario);
    }
    @PostMapping("/actualizarUsuario") //A través de un método Post en la ruta declarada se actualiza el usuario pasado en la petición y se devuelve el usuario actualizado
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        Usuario usuarioActualizado = usuarioDAO.updateUsuario(usuario);
        return usuarioActualizado;
    }

    @PostMapping ("/borrarUsuario")  //A través de un método Post en la ruta declarada eliminamos el usuario pasado en la petición
    public void borrarUusario(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        int res = usuarioDAO.RemoveUsuario(usuario);
        System.out.println("Usuario: " + usuario.getNombreUsuario() + " eliminado: " + res);
    }
}
