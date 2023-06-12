package com.ProyectoDamMPR.TimeToWork.dao;
import com.ProyectoDamMPR.TimeToWork.modelo.Empresa;

public interface EmpresaDAO { //Con esta interfaz declaramos los métodos abstractos de las funciones CRUD(Crear, leer, actualizar y borrar) para la entidad Empresa
    public int crearEmpresaUsuario(Empresa empresa); //Creamos en la base de datos la empresa pasada
}
