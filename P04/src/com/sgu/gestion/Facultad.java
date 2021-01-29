//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoFacultad;
import com.sgu.objs.ObjFacultad;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Facultad</p>
 * <p>Description: Objeto para gestionar las facultades.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Facultad
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Facultad ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoFacultad();
        this.tracer.debug("Facultad", "Facultad()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está una facultad en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id, int universidad)
    {
        tracer.debug("Facultad", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(id, universidad);
        tracer.debug("Facultad", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está una facultad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjFacultad obj)
    {
        tracer.debug("Facultad", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getID(), obj.getUniversidad());
        tracer.debug("Facultad", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar una facultad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjFacultad obj)
    {
        this.tracer.debug("Facultad", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Facultad", "insertar()", "La facultad ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Facultad", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar una facultad en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     */
    public void eliminar (int id, int universidad)
    {
        this.tracer.debug("Facultad", "eliminar()", "Iniciando operación...");

        if(this.existe(id, universidad))
        {
            this.dao.eliminar(id, universidad);
            this.tracer.debug("Facultad", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Facultad", "eliminar", "La facultad no existe.");
        }
    }

    /**
     * Método para eliminar una facultad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjFacultad obj)
    {
        this.tracer.debug("Facultad", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getID(), obj.getUniversidad()))
        {
            this.dao.eliminar(obj.getID(), obj.getUniversidad());
            this.tracer.debug("Facultad", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Facultad", "eliminar", "La facultad no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar una facultad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjFacultad obj)
    {
        this.tracer.debug("Facultad", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Facultad", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Facultad", "modificar()", "La facultad no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener una facultad en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjFacultad buscar (int id, int universidad)
    {
        this.tracer.debug("Facultad", "buscar()", "Iniciando operación...");
        ObjFacultad obj = null;

        if(this.existe(id, universidad))
        {
            obj = this.dao.buscar(id, universidad);
            this.tracer.debug("Facultad", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Facultad", "buscar()", "La facultad no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todas las facultades en la base de datos.
     * @return LinkedList&lt;ObjFacultad&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjFacultad> listar ()
    {
        this.tracer.debug("Facultad", "listar()", "Iniciando operación...");
        LinkedList<ObjFacultad> obj = this.dao.buscar();
        this.tracer.debug("Facultad", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoFacultad dao;
    private Tracer tracer;
}
