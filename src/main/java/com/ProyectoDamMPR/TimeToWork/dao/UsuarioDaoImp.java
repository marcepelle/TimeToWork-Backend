package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.CorreoContrasena;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import com.ProyectoDamMPR.TimeToWork.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Repository //Declaramos que la clase será un componente encargado de resolver el acceso y la gestión de los datos en la BBDD para la entidad Usuario, es la capa de persistencia
@Transactional //Declaramos el comportamiento de los métodos de la clase en referencia a las transacciones, de manera predeterminada es REQUIRED que indica que si existe una transacción en curso se usará esa y si no creará una nueva
public class UsuarioDaoImp implements UsuarioDAO { //implementamos la interfaz UsuarioDAO

    @PersistenceContext //Inyecta automaticamente una referencia apropiada del EntityManager
    EntityManager entityManager; //Creamos un objeto EntityManager para establecer una conexión transaccional con la BBDD y gestionar las entidades
    @Override
    public Usuario loginUsuario(CorreoContrasena correoContrasena) { //Devolverá el usuario para la sesión si para el objeto CorreoContrasena pasado los datos son correctos
        List<Usuario> usuarios = entityManager.createQuery(" FROM Usuario u WHERE u.correoUsuario = :email")
                .setParameter("email", correoContrasena.getCorreo())
                .getResultList(); //Hacemos una consulta para obtener el/los usuario/s de la tabla Usuario donde en la columna correoUsuario coincide el registro con el correo pasado
        System.out.println("Usuarios Vacio: " + usuarios.isEmpty());
        String hashCorreoContrasena = obtenerHash(correoContrasena.getPassword()); //Obtenemos el hash de la contraseña pasada
        System.out.println("contrasena DAO: " + hashCorreoContrasena);
        if(!usuarios.isEmpty()){ //Si el listado de usuarios obtenido en la consulta no esta vacío
            List<Empresa> empresas = entityManager.createQuery(" FROM Empresa e WHERE e.nombreEmpresa = :nom").setParameter("nom", usuarios.get(0).getEmpresaUsuario()).getResultList(); //Hacemos una consulta para obtener la/las empresa/s de la tabla Empresa donde en la columna nombreEmpresa coincide el registro con el nombre de la empresa pasada
            System.out.println("Empresas vacio: " + empresas.isEmpty());
            usuarios.get(0).setEmpresa_fk(empresas.get(0)); //fijamos el objeto empresa que nos ha devuelto la consulta en el atributo que corresponde a la clave ajena de Usuario
            if(hashCorreoContrasena.equals(usuarios.get(0).getContrasena())){ //Sí el hash de la contraseña pasada coincide con el hash de la contraseña
                System.out.println("Dentro");
                entityManager.flush(); //sincronizamos la conexión con la base de datos
                return usuarios.get(0); //devolvemos el usuario para la sesión
            }
        }
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return null; //si no coincide la contraseña devolvemos null
    }

    @Override
    public void crearUsuario(Usuario u) { //Creamos el usuario pasado en la base de datos
        List<Empresa> empresas = entityManager.createQuery(" FROM Empresa e WHERE e.nombreEmpresa = :nom")
                .setParameter("nom", u.getEmpresaUsuario())
                .getResultList();  // La consulta nos devolverá un listado de empresas para los registros que contengan el nombre de la empresa que corresponde del usuario pasado
        u.setEmpresa_fk(empresas.get(0)); //fijamos el objeto empresa que nos ha devuelto la consulta en el atributo que corresponde a la clave ajena de Usuario
        String hashContrasena = obtenerHash(u.getContrasena()); //obtenemos el hash de la contraseña que introdujo el usuario
        u.setContrasena(hashContrasena); //fijamos la contraseña haseheada
        entityManager.persist(u); //hacemos que persista el objeto Usuario en la base de datos
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        System.out.println("Usuario creado");
    }

    private String obtenerHash(String contrasena) { //Método para obtener el hash de la contraseña pasada

        String hashContrasena = null;
        try {
            MessageDigest hashear = MessageDigest.getInstance("SHA-256"); //La clase MessageDigest permite trabajar con funciones hash como SHA-256
            hashear.reset();
            hashear.update(contrasena.getBytes("utf8")); //Obtenemos el encoding en bytes de la contraseña para poder hashearla
            hashContrasena = String.format("%064x", new BigInteger(1, hashear.digest())); //hasheamos la contraseña
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashContrasena;
    }

    public Usuario getUsuario(CorreoContrasena correoContrasena){ //Devuelve el usuario para el correo pasado
        System.out.println("En obtencion de Usuario");
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery(" FROM Usuario u WHERE u.correoUsuario = :email")
                .setParameter("email", correoContrasena.getCorreo())
                .getResultList(); //Obtenemos el listado de usuarios para los registros en lo que coinciden el correo pasado por parámetro
        if (usuarios.size()!=0){ //si el listado de usuarios no esta vacío
            System.out.println("Usuario: " + usuarios.get(0));
            return usuarios.get(0); //Devolvemos el usuario
        }
        return new Usuario(); //Si no devolvemos un Usuario vacío
    }

    public ArrayList<Usuario> getUsuarios(Usuario usuario){ //Devuelve un listado de usuarios para la empresa del usuario pasado
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery("FROM Usuario u WHERE u.empresaUsuario = :emp")
                .setParameter("emp", usuario.getEmpresaUsuario())
                .getResultList(); //Obtenemos el listado de usuarios para los registros en lo que coinciden la empresa pasada por parámetro
        System.out.println("Obteniendo lista : " + usuarios.size() + usuarios.get(0).getNombreUsuario());
        return usuarios; //devolvemos el listado de usuarios
    }
    public Usuario updateUsuario(Usuario usuario){ //Actualizamos los datos del usuario pasado y devolvemos el usuario actualizado
        System.out.println("actualizando");
        String hashContrasena = obtenerHash(usuario.getContrasena());
        usuario.setContrasena(hashContrasena);
        Usuario usuarioActualizado = entityManager.merge(usuario); //Merge combina los valores nuevos con los antiguos para actualizar el objeto usuario pasado
        System.out.println(usuarioActualizado.toString());
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return usuarioActualizado; //Devolvemos el usuario actualizado
    }

    public int RemoveUsuario(Usuario usuario){ //Devuelve 1 si el borrado del usuario pasado fue exitoso o 0 si no se consigue borrar
        System.out.println("Eliminando " + usuario.getNombreUsuario());
        int resRemove = entityManager.createQuery("delete Usuario u where u.idUsuario = :id")
                .setParameter("id", usuario.getIdUsuario())
                .executeUpdate(); //Hacemos el delete donde el id del usuario coincide con el pasado por parámetro
        entityManager.flush(); //sincronizamos la conexión con la base de datos
        return resRemove; //devolvemos el resultado del delete
    }
}
