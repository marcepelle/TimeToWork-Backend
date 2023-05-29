package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional //Declaramos que la clase será un componente encargado de resolver el acceso y la gestión de los datos en la BBDD para la entidad Empresa, es la capa de persistencia
@Repository  //Declaramos el comportamiento de los métodos de la clase en referencia a las transacciones, de manera predeterminada es REQUIRED que indica que si existe una transacción en curso se usará esa y si no creará una nueva
public class
EmpresaDAOImp implements EmpresaDAO { //implementamos la interfaz EmpresaDAO
    @PersistenceContext //Inyecta automaticamente una referencia apropiada del EntityManager
    EntityManager entityManager; //Creamos un objeto EntityManager para establecer una conexión transaccional con la BBDD y gestionar las entidades
    @Override
    public void crearEmpresaUsuario(Empresa empresa) { //Creamos en la base de datos la empresa pasada
        entityManager.persist(empresa); //hacemos que persista el objeto Empresa en la base de datos
        entityManager.flush(); //sincronizamos la conexión con la base de datos
    }
}
