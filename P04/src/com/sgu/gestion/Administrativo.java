//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoAdministrativo;
import com.sgu.objs.ObjAdministrativo;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Administrativo</p>
 * <p>Description: Objeto para gestionar los administrativos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Administrativo
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Administrativo ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoAdministrativo();
        this.tracer.debug("Administrativo", "Administrativo()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está un administrativo en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int dni, int universidad, int facultad)
    {
        tracer.debug("Administrativo", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(dni, universidad, facultad);
        tracer.debug("Administrativo", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está un administrativo en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjAdministrativo obj)
    {
        tracer.debug("Administrativo", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getDNI(), obj.getUniversidad(),
                                             obj.getFacultad());
        tracer.debug("Administrativo", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar un administrativo en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjAdministrativo obj)
    {
        this.tracer.debug("Administrativo", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Administrativo", "insertar()", "El administrativo ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Administrativo", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un administrativo en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int dni, int universidad, int facultad)
    {
        this.tracer.debug("Administrativo", "eliminar()", "Iniciando operación...");

        if(this.existe(dni, universidad, facultad))
        {
            this.dao.eliminar(dni, universidad, facultad);
            this.tracer.debug("Administrativo", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Administrativo", "eliminar", "El administrativo no existe.");
        }
    }

    /**
     * Método para eliminar un administrativo en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjAdministrativo obj)
    {
        this.tracer.debug("Administrativo", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getDNI(), obj.getUniversidad(), obj.getFacultad()))
        {
            this.dao.eliminar(obj.getDNI(), obj.getUniversidad(), obj.getFacultad());
            this.tracer.debug("Administrativo", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Administrativo", "eliminar", "El administrativo no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar un administrativo en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjAdministrativo obj)
    {
        this.tracer.debug("Administrativo", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Administrativo", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Administrativo", "modificar()", "El administrativo no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener un administrativo en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjAdministrativo buscar (int dni, int universidad, int facultad)
    {
        this.tracer.debug("Administrativo", "buscar()", "Iniciando operación...");
        ObjAdministrativo obj = null;

        if(this.existe(dni, universidad, facultad))
        {
            obj = this.dao.buscar(dni, universidad, facultad);
            this.tracer.debug("Administrativo", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Administrativo", "buscar()", "El administrativo no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todos los administrativos en la base de datos.
     * @return LinkedList&lt;ObjAdministrativo&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjAdministrativo> listar ()
    {
        this.tracer.debug("Administrativo", "listar()", "Iniciando operación...");
        LinkedList<ObjAdministrativo> obj = this.dao.buscar();
        this.tracer.debug("Administrativo", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoAdministrativo dao;
    private Tracer tracer;
}
