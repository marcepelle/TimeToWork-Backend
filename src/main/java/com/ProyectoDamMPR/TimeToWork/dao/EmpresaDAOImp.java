package com.ProyectoDamMPR.TimeToWork.dao;

import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class
EmpresaDAOImp implements EmpresaDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void crearEmpresaUsuario(Empresa empresa) {
        entityManager.persist(empresa);
        entityManager.flush();
    }
}
