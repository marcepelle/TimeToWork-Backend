package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Transactional //Declaramos que la clase será un componente encargado de resolver el acceso y la gestión de los datos en la BBDD para la entidad Empresa, es la capa de persistencia
@Repository  //Declaramos el comportamiento de los métodos de la clase en referencia a las transacciones, de manera predeterminada es REQUIRED que indica que si existe una transacción en curso se usará esa y si no creará una nueva
public class
EmpresaDAOImp implements EmpresaDAO { //implementamos la interfaz EmpresaDAO
    @PersistenceContext //Inyecta automaticamente una referencia apropiada del EntityManager
    EntityManager entityManager; //Creamos un objeto EntityManager para establecer una conexión transaccional con la BBDD y gestionar las entidades
    @Override
    public int crearEmpresaUsuario(Empresa empresa) { //Creamos en la base de datos la empresa pasada
        try{
            List<Empresa> empresasNombre = entityManager.createQuery(" FROM Empresa e WHERE e.nombreEmpresa = :nom")
                    .setParameter("nom", empresa.getNombreEmpresa())
                    .getResultList();  // La consulta nos devolverá un listado de empresas para los registros que contengan el nombre de la empresa pasada
            List<Empresa> empresasCIF = entityManager.createQuery(" FROM Empresa e WHERE e.cif = :cif")
                    .setParameter("cif", empresa.getCif())
                    .getResultList();  // La consulta nos devolverá un listado de empresas para los registros que contengan el CIF de la empresa pasada
            if(empresasNombre.isEmpty() && empresasCIF.isEmpty()){ //comprobamos que no exista una empresa con el mismo nombre y CIF de la que se va a crear
                entityManager.persist(empresa); //hacemos que persista el objeto Empresa en la base de datos
                entityManager.flush(); //sincronizamos la conexión con la base de datos
                return 1; //si la empresa se crea devolvemos un 1
            }
                return 0; //si la empresa no se crea devolvemos un 0
        }catch (Exception e){
            System.out.println("Error al crear la empresa: " + empresa.getNombreEmpresa() + " Error: " + e.getMessage());
            return 0;
        }
    }
}
