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
    public int crearUsuario(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        return usuarioDAO.crearUsuario(usuario);
    }
    @PostMapping("/crearEmpresa") //A través de un método Post en la ruta declarada se creará la Empresa que se envío en la petición
    public int crearEmpresa(@RequestBody Empresa empresa){ //Con RequestBody deserializamos un objeto Empresa a partir del cuerpo de la petición
        return empresaDAO.crearEmpresaUsuario(empresa);
    }
    @GetMapping ("/loginUsuario") //A través de un método Post en la ruta declarada se devolverá el Usuario para la sesión si para el objeto correoContrasena que se envío en la petición los datos existen en la base de datos y son correctos
    public Usuario iniciarSesion(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena) { //Con RequestBody deserializamos un objeto CorreoContrasena a partir del cuerpo de la petición
        CorreoContrasena correoContrasena = new CorreoContrasena(correo, contrasena);
        System.out.println("Coreo y contrasena: " + correoContrasena.toString());
        Usuario usuarioLogged = usuarioDAO.loginUsuario(correoContrasena);
        return usuarioLogged;
    }
    @GetMapping("/obtenerUsuario") //A través de un método Post en la ruta declarada se devolverá un Usuario si para el objeto correoContrasena que se envío en la petición los datos existen en la base de datos y son correctos
    public Usuario obtenerUsuario(@RequestParam("correo") String correo){ //Con RequestBody deserializamos un objeto CorreoContrasena a partir del cuerpo de la petición
        return usuarioDAO.getUsuario(correo);
    }
    @GetMapping ("/listarUsuarios") //A través de un método Post en la ruta declarada se devuelve un listado de usuarios para el usuario pasado en la petición
    public ArrayList<Usuario> listarUsuarios(@RequestParam String empresa){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        return usuarioDAO.getUsuarios(empresa);
    }
    @PutMapping("/actualizarUsuario") //A través de un método Post en la ruta declarada se actualiza el usuario pasado en la petición y se devuelve el usuario actualizado
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        Usuario usuarioActualizado = usuarioDAO.updateUsuario(usuario);
        return usuarioActualizado;
    }
    @PutMapping("/actualizarContrasena") //A través de un método Post en la ruta declarada se actualiza la contraseña del usuario pasado en la petición y se devuelve el usuario actualizado
    public Usuario actualizarContrasena(@RequestBody Usuario usuario){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        Usuario usuarioActualizado = usuarioDAO.updateContrasena(usuario);
        return usuarioActualizado;
    }

    @DeleteMapping ("/borrarUsuario/{id}")  //A través de un método Post en la ruta declarada eliminamos el usuario pasado en la petición
    public int borrarUusario(@PathVariable("id") int id){ //Con RequestBody deserializamos un objeto Usuario a partir del cuerpo de la petición
        int res = usuarioDAO.RemoveUsuario(id);
        System.out.println(" eliminado: " + res);
        return res;
    }
}
