//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoUniversidad;
import com.sgu.objs.ObjUniversidad;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Universidad</p>
 * <p>Description: Objeto para gestionar las universidades.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Universidad
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Universidad ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoUniversidad();
        this.tracer.debug("Universidad", "Universidad()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está una universidad en la base de datos.
     * @param id ID del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id)
    {
        tracer.debug("Universidad", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(id);
        tracer.debug("Universidad", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está una universidad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjUniversidad obj)
    {
        tracer.debug("Universidad", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getID());
        tracer.debug("Universidad", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar una universidad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjUniversidad obj)
    {
        this.tracer.debug("Universidad", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Universidad", "insertar()", "La universidad ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Universidad", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar una universidad en la base de datos.
     * @param id ID del elemento.
     */
    public void eliminar (int id)
    {
        this.tracer.debug("Universidad", "eliminar()", "Iniciando operación...");

        if(this.existe(id))
        {
            this.dao.eliminar(id);
            this.tracer.debug("Universidad", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Universidad", "eliminar", "La universidad no existe.");
        }
    }

    /**
     * Método para eliminar una universidad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjUniversidad obj)
    {
        this.tracer.debug("Universidad", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getID()))
        {
            this.dao.eliminar(obj.getID());
            this.tracer.debug("Universidad", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Universidad", "eliminar", "La universidad no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar una universidad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjUniversidad obj)
    {
        this.tracer.debug("Universidad", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Universidad", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Universidad", "modificar()", "La universidad no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener una universidad en la base de datos.
     * @param id ID del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjUniversidad buscar (int id)
    {
        this.tracer.debug("Universidad", "buscar()", "Iniciando operación...");
        ObjUniversidad obj = null;

        if(this.existe(id))
        {
            obj = this.dao.buscar(id);
            this.tracer.debug("Universidad", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Universidad", "buscar()", "La universidad no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todas las universidades en la base de datos.
     * @return LinkedList&lt;ObjUniversidad&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjUniversidad> listar ()
    {
        this.tracer.debug("Universidad", "listar()", "Iniciando operación...");
        LinkedList<ObjUniversidad> obj = this.dao.buscar();
        this.tracer.debug("Universidad", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoUniversidad dao;
    private Tracer tracer;
}
