//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.gestion;
import com.sgu.daos.DaoCurso;
import com.sgu.objs.ObjCurso;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.gestion.Curso</p>
 * <p>Description: Objeto para gestionar los cursos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Curso
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public Curso ()
    {
        this.tracer = new Tracer();
        this.dao = new DaoCurso();
        this.tracer.debug("Curso", "Curso()", "Objeto creado.");

    }

    //-----------------------------------------------------------------------
    /**
     * Método para saber si está un curso en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id, int universidad, int facultad)
    {
        tracer.debug("Curso", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(id, universidad, facultad);
        tracer.debug("Curso", "existe()", "Operación finalizada.");
        return encontrado;
    }

    /**
     * Método para saber si está un curso en la base de datos.
     * @param obj Objeto con los datos del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (ObjCurso obj)
    {
        tracer.debug("Curso", "existe()", "Iniciando operación...");
        boolean encontrado = this.dao.existe(obj.getID(), obj.getUniversidad(),
                                             obj.getFacultad());
        tracer.debug("Curso", "existe()", "Operación finalizada.");
        return encontrado;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para insertar un curso en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjCurso obj)
    {
        this.tracer.debug("Curso", "insertar()", "Iniciando operación...");

        if(this.existe(obj))
        {
            this.tracer.error("Curso", "insertar()", "El curso ya existe.");
        }
        else
        {
            this.dao.insertar(obj);
            this.tracer.debug("Curso", "insertar()", "Operación finalizada.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un curso en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Curso", "eliminar()", "Iniciando operación...");

        if(this.existe(id, universidad, facultad))
        {
            this.dao.eliminar(id, universidad, facultad);
            this.tracer.debug("Curso", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Curso", "eliminar", "El curso no existe.");
        }
    }

    /**
     * Método para eliminar un curso en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void eliminar (ObjCurso obj)
    {
        this.tracer.debug("Curso", "eliminar()", "Iniciando operación...");

        if(this.existe(obj.getID(), obj.getUniversidad(), obj.getFacultad()))
        {
            this.dao.eliminar(obj.getID(), obj.getUniversidad(), obj.getFacultad());
            this.tracer.debug("Curso", "eliminar", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Curso", "eliminar", "El curso no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para modificar un curso en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjCurso obj)
    {
        this.tracer.debug("Curso", "modificar()", "Iniciando operación...");
        if(this.existe(obj))
        {
            this.dao.modificar(obj);
            this.tracer.debug("Curso", "modificar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Curso", "modificar()", "El curso no existe.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener un curso en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjCurso buscar (int id, int universidad, int facultad)
    {
        this.tracer.debug("Curso", "buscar()", "Iniciando operación...");
        ObjCurso obj = null;

        if(this.existe(id, universidad, facultad))
        {
            obj = this.dao.buscar(id, universidad, facultad);
            this.tracer.debug("Curso", "buscar()", "Operación finalizada.");
        }
        else
        {
            this.tracer.error("Curso", "buscar()", "El curso no existe.");
        }

        return obj;
    }

    //-----------------------------------------------------------------------
    /**
     * Método para obtener todos los cursos en la base de datos.
     * @return LinkedList&lt;ObjCurso&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjCurso> listar ()
    {
        this.tracer.debug("Curso", "listar()", "Iniciando operación...");
        LinkedList<ObjCurso> obj = this.dao.buscar();
        this.tracer.debug("Curso", "listar()", "Operación finalizada.");
        return obj;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private DaoCurso dao;
    private Tracer tracer;
}
