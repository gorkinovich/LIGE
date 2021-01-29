//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoAsignatura;
import com.sgu.objs.ObjAsignatura;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Asignatura</p>
 * <p>Description: Objeto para gestionar las asignaturas.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Asignatura
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Asignatura ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoAsignatura();
        this.tracer.debug("Asignatura", "Asignatura()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está una asignatura en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id, int universidad, int facultad)
    {
        tracer.debug("Asignatura", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(id, universidad, facultad);
        tracer.debug("Asignatura", "existe()", "0peración finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está una asignatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjAsignatura obj)
    {
        tracer.debug("Asignatura", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getID(), obj.getUniversidad(),
                                             obj.getFacultad());
        tracer.debug("Asignatura", "existe()", "0peración finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar una asignatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjAsignatura obj)
    {
        this.tracer.debug("Asignatura", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Asignatura", "insertar()", "La asignatura ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Asignatura", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar una asignatura en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Asignatura", "eliminar()", "Iniciando operación...");

        if(this.existe(id, universidad, facultad))
        {
            this.dao.eliminar(id, universidad, facultad);
            this.tracer.debug("Asignatura", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Asignatura", "eliminar", "La asignatura no existe.");
        }
    }

    /**
     * Método para eliminar una asignatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjAsignatura obj)
    {
        this.tracer.debug("Asignatura", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getID(), obj.getUniversidad(), obj.getFacultad()))
        {
            this.dao.eliminar(obj.getID(), obj.getUniversidad(), obj.getFacultad());
            this.tracer.debug("Asignatura", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Asignatura", "eliminar", "La asignatura no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar una asignatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjAsignatura obj)
    {
        this.tracer.debug("Asignatura", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Asignatura", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Asignatura", "modificar()", "La asignatura no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener una asignatura en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjAsignatura buscar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Asignatura", "buscar()", "Iniciando operación...");
        ObjAsignatura obj = null;

        if(this.existe(id, universidad, facultad))
        {
            obj = this.dao.buscar(id, universidad, facultad);
            this.tracer.debug("Asignatura", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Asignatura", "buscar()", "La asignatura no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todas las asignaturas en la base de datos.
     * @return LinkedList&lt;ObjAsignatura&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjAsignatura> listar ()
    {
        this.tracer.debug("Asignatura", "listar()", "Iniciando operación...");
        LinkedList<ObjAsignatura> obj = this.dao.buscar();
        this.tracer.debug("Asignatura", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoAsignatura dao;
    private Tracer tracer;
}
