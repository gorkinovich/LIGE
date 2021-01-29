//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoProfesor;
import com.sgu.objs.ObjProfesor;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Profesor</p>
 * <p>Description: Objeto para gestionar los profesores.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Profesor
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Profesor ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoProfesor();
        this.tracer.debug("Profesor", "Profesor()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está un profesor en la base de datos.
     * @param dni          DNI del elemento.
     * @param universidad  ID de la universidad del elemento.
     * @param facultad     ID de la facultad del elemento.
     * @param departamento ID del departamento del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int dni, int universidad, int facultad, int departamento)
    {
        tracer.debug("Profesor", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(dni, universidad, facultad, departamento);
        tracer.debug("Profesor", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está un profesor en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjProfesor obj)
    {
        tracer.debug("Profesor", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getDNI(), obj.getUniversidad(),
                                             obj.getFacultad(), obj.getDepartamento());
        tracer.debug("Profesor", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar un profesor en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjProfesor obj)
    {
        this.tracer.debug("Profesor", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Profesor", "insertar()", "El profesor ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Profesor", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un profesor en la base de datos.
     * @param dni          DNI del elemento.
     * @param universidad  ID de la universidad del elemento.
     * @param facultad     ID de la facultad del elemento.
     * @param departamento ID del departamento del elemento.
     */
    public void eliminar (int dni, int universidad, int facultad, int departamento)
    {
        this.tracer.debug("Profesor", "eliminar()", "Iniciando operación...");

        if(this.existe(dni, universidad, facultad, departamento))
        {
            this.dao.eliminar(dni, universidad, facultad, departamento);
            this.tracer.debug("Profesor", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Profesor", "eliminar", "El profesor no existe.");
        }
    }

    /**
     * Método para eliminar un profesor en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjProfesor obj)
    {
        this.tracer.debug("Profesor", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getDNI(), obj.getUniversidad(), obj.getFacultad(),
                       obj.getDepartamento()))
        {
            this.dao.eliminar(obj.getDNI(), obj.getUniversidad(), obj.getFacultad(),
                              obj.getDepartamento());
            this.tracer.debug("Profesor", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Profesor", "eliminar", "El profesor no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar un profesor en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjProfesor obj)
    {
        this.tracer.debug("Profesor", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Profesor", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Profesor", "modificar()", "El profesor no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener un profesor en la base de datos.
     * @param dni          DNI del elemento.
     * @param universidad  ID de la universidad del elemento.
     * @param facultad     ID de la facultad del elemento.
     * @param departamento ID del departamento del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjProfesor buscar (int dni, int universidad, int facultad, int departamento)
    {
        this.tracer.debug("Profesor", "buscar()", "Iniciando operación...");
        ObjProfesor obj = null;

        if(this.existe(dni, universidad, facultad, departamento))
        {
            obj = this.dao.buscar(dni, universidad, facultad, departamento);
            this.tracer.debug("Profesor", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Profesor", "buscar()", "El profesor no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todos los profesores en la base de datos.
     * @return LinkedList&lt;ObjProfesor&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjProfesor> listar ()
    {
        this.tracer.debug("Profesor", "listar()", "Iniciando operación...");
        LinkedList<ObjProfesor> obj = this.dao.buscar();
        this.tracer.debug("Profesor", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoProfesor dao;
    private Tracer tracer;
}
