//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoLicenciatura;
import com.sgu.objs.ObjLicenciatura;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Licenciatura</p>
 * <p>Description: Objeto para gestionar las licenciaturas.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Licenciatura
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Licenciatura ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoLicenciatura();
        this.tracer.debug("Licenciatura", "Licenciatura()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está una licenciatura en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id, int universidad, int facultad)
    {
        tracer.debug("Licenciatura", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(id, universidad, facultad);
        tracer.debug("Licenciatura", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está una licenciatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjLicenciatura obj)
    {
        tracer.debug("Licenciatura", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getID(), obj.getUniversidad(),
                                             obj.getFacultad());
        tracer.debug("Licenciatura", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar una licenciatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjLicenciatura obj)
    {
        this.tracer.debug("Licenciatura", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Licenciatura", "insertar()", "La licenciatura ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Licenciatura", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar una licenciatura en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Licenciatura", "eliminar()", "Iniciando operación...");

        if(this.existe(id, universidad, facultad))
        {
            this.dao.eliminar(id, universidad, facultad);
            this.tracer.debug("Licenciatura", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Licenciatura", "eliminar", "La licenciatura no existe.");
        }
    }

    /**
     * Método para eliminar una licenciatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjLicenciatura obj)
    {
        this.tracer.debug("Licenciatura", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getID(), obj.getUniversidad(), obj.getFacultad()))
        {
            this.dao.eliminar(obj.getID(), obj.getUniversidad(), obj.getFacultad());
            this.tracer.debug("Licenciatura", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Licenciatura", "eliminar", "La licenciatura no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar una licenciatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjLicenciatura obj)
    {
        this.tracer.debug("Licenciatura", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Licenciatura", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Licenciatura", "modificar()", "La licenciatura no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener una licenciatura en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjLicenciatura buscar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Licenciatura", "buscar()", "Iniciando operación...");
        ObjLicenciatura obj = null;

        if(this.existe(id, universidad, facultad))
        {
            obj = this.dao.buscar(id, universidad, facultad);
            this.tracer.debug("Licenciatura", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Licenciatura", "buscar()", "La licenciatura no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todas las licenciaturas en la base de datos.
     * @return LinkedList&lt;ObjLicenciatura&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjLicenciatura> listar ()
    {
        this.tracer.debug("Licenciatura", "listar()", "Iniciando operación...");
        LinkedList<ObjLicenciatura> obj = this.dao.buscar();
        this.tracer.debug("Licenciatura", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoLicenciatura dao;
    private Tracer tracer;
}
