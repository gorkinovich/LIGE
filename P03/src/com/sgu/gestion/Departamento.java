//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoDepartamento;
import com.sgu.objs.ObjDepartamento;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Departamento</p>
 * <p>Description: Objeto para gestionar los departamentos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Departamento
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Departamento ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoDepartamento();
        this.tracer.debug("Departamento", "Departamento()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está un departamento en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id, int universidad, int facultad)
    {
        tracer.debug("Departamento", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(id, universidad, facultad);
        tracer.debug("Departamento", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está un departamento en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjDepartamento obj)
    {
        tracer.debug("Departamento", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getID(), obj.getUniversidad(),
                                             obj.getFacultad());
        tracer.debug("Departamento", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar un departamento en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjDepartamento obj)
    {
        this.tracer.debug("Departamento", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Departamento", "insertar()", "El departamento ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Departamento", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un departamento en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Departamento", "eliminar()", "Iniciando operación...");

        if(this.existe(id, universidad, facultad))
        {
            this.dao.eliminar(id, universidad, facultad);
            this.tracer.debug("Departamento", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Departamento", "eliminar", "El departamento no existe.");
        }
    }

    /**
     * Método para eliminar un departamento en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjDepartamento obj)
    {
        this.tracer.debug("Departamento", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getID(), obj.getUniversidad(), obj.getFacultad()))
        {
            this.dao.eliminar(obj.getID(), obj.getUniversidad(), obj.getFacultad());
            this.tracer.debug("Departamento", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Departamento", "eliminar", "El departamento no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar un departamento en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjDepartamento obj)
    {
        this.tracer.debug("Departamento", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Departamento", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Departamento", "modificar()", "El departamento no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener un departamento en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjDepartamento buscar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Departamento", "buscar()", "Iniciando operación...");
        ObjDepartamento obj = null;

        if(this.existe(id, universidad, facultad))
        {
            obj = this.dao.buscar(id, universidad, facultad);
            this.tracer.debug("Departamento", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Departamento", "buscar()", "El departamento no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todos los departamentos en la base de datos.
     * @return LinkedList&lt;ObjDepartamento&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjDepartamento> listar ()
    {
        this.tracer.debug("Departamento", "listar()", "Iniciando operación...");
        LinkedList<ObjDepartamento> obj = this.dao.buscar();
        this.tracer.debug("Departamento", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoDepartamento dao;
    private Tracer tracer;
}
