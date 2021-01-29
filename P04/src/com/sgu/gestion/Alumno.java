//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoAlumno;
import com.sgu.objs.ObjAlumno;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Alumno</p>
 * <p>Description: Objeto para gestionar los alumnos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Alumno
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Alumno ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoAlumno();
        this.tracer.debug("Alumno", "Alumno()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está un alumno en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int dni, int universidad, int facultad)
    {
        tracer.debug("Alumno", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(dni, universidad, facultad);
        tracer.debug("Alumno", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está un alumno en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjAlumno obj)
    {
        tracer.debug("Alumno", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getDNI(), obj.getUniversidad(),
                                             obj.getFacultad());
        tracer.debug("Alumno", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar un alumno en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjAlumno obj)
    {
        this.tracer.debug("Alumno", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Alumno", "insertar()", "El alumno ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Alumno", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un alumno en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int dni, int universidad, int facultad)
    {
        this.tracer.debug("Alumno", "eliminar()", "Iniciando operación...");

        if(this.existe(dni, universidad, facultad))
        {
            this.dao.eliminar(dni, universidad, facultad);
            this.tracer.debug("Alumno", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Alumno", "eliminar", "El alumno no existe.");
        }
    }

    /**
     * Método para eliminar un alumno en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjAlumno obj)
    {
        this.tracer.debug("Alumno", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getDNI(), obj.getUniversidad(), obj.getFacultad()))
        {
            this.dao.eliminar(obj.getDNI(), obj.getUniversidad(), obj.getFacultad());
            this.tracer.debug("Alumno", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Alumno", "eliminar", "El alumno no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar un alumno en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjAlumno obj)
    {
        this.tracer.debug("Alumno", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Alumno", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Alumno", "modificar()", "El alumno no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener un alumno en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjAlumno buscar (int dni, int universidad, int facultad)
    {
        this.tracer.debug("Alumno", "buscar()", "Iniciando operación...");
        ObjAlumno obj = null;

        if(this.existe(dni, universidad, facultad))
        {
            obj = this.dao.buscar(dni, universidad, facultad);
            this.tracer.debug("Alumno", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Alumno", "buscar()", "El alumno no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todos los alumnos en la base de datos.
     * @return LinkedList&lt;ObjAlumno&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjAlumno> listar ()
    {
        this.tracer.debug("Alumno", "listar()", "Iniciando operación...");
        LinkedList<ObjAlumno> obj = this.dao.buscar();
        this.tracer.debug("Alumno", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoAlumno dao;
    private Tracer tracer;
}
