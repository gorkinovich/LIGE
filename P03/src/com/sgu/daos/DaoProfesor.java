//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjProfesor;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoProfesor</p>
 * <p>Description: Objeto para acceder a los datos de un profesor.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoProfesor
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoProfesor ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoProfesor", "DaoProfesor()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar un profesor en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjProfesor obj)
    {
        this.tracer.debug("DaoProfesor", "insertar()", "Iniciando la inserción...");
        String valores = obj.getDNI() + ", " + obj.getUniversidad() + ", " +
                         obj.getFacultad() + ", " + obj.getDepartamento() + ", '" +
                         obj.getNombre() + "'" + ", '" + obj.getApellidos() + "'";
        this.util.insertar("PROFESORES", valores);
        this.tracer.debug("DaoProfesor", "insertar()", "Insercion finalizada.");
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
        this.tracer.debug("DaoProfesor", "eliminar()", "Iniciando eliminación...");
        String condicion = "DNI=" + dni + " AND UNIVERSIDAD=" + universidad +
                           " AND FACULTAD=" + facultad + " AND DEPARTAMENTO=" +
                           departamento;
        this.util.eliminar("PROFESORES", condicion);
        this.tracer.debug("DaoProfesor", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar un profesor en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjProfesor obj)
    {
        this.tracer.debug("DaoProfesor", "actualizar()", "Iniciando la modificación...");
        String condicion = "DNI=" + obj.getDNI() + " AND UNIVERSIDAD=" + obj.getUniversidad() +
                           " AND FACULTAD=" + obj.getFacultad() + " AND DEPARTAMENTO=" +
                           obj.getDepartamento();
        String valores = "NOMBRE='" + obj.getNombre() + "', APELLIDOS='" + obj.getApellidos() + "'";
        this.util.modificar("PROFESORES", valores, condicion);
        this.tracer.debug("DaoProfesor", "actualizar()", "Modificación finalizada.");
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
        this.tracer.debug("DaoProfesor", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM PROFESORES WHERE DNI=" + dni +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" +
                           facultad + " AND DEPARTAMENTO=" + departamento;
            ConsultaProfesor result = new ConsultaProfesor();
            this.util.consultar(query, result);

            LinkedList<ObjProfesor> lista = result.getLista();
            for(ObjProfesor regact : lista)
            {
                if((regact.getDNI() != 0) && (dni == regact.getDNI()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()) &&
                   (regact.getDepartamento() != 0) && (departamento == regact.getDepartamento()))
                {
                    this.tracer.debug("DaoProfesor", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoProfesor", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoProfesor", "existe()", "busqueda finalizada.");
        return existe;
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
        this.tracer.debug("DaoProfesor", "buscar()", "Iniciando la consulta...");
        ObjProfesor obj = null;

        try
        {
            String query = "SELECT * FROM PROFESORES WHERE DNI=" + dni +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" +
                           facultad + " AND DEPARTAMENTO=" + departamento;
            ConsultaProfesor result = new ConsultaProfesor();
            this.util.consultar(query, result);

            LinkedList<ObjProfesor> lista = result.getLista();
            for(ObjProfesor regact : lista)
            {
                if((regact.getDNI() != 0) && (dni == regact.getDNI()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()) &&
                   (regact.getDepartamento() != 0) && (departamento == regact.getDepartamento()))
                {
                    this.tracer.debug("DaoProfesor", "buscar()", "La consulta no es nula.");
                    obj = new ObjProfesor(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoProfesor", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoProfesor", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener un profesor en la base de datos.
     * @return LinkedList&lt;ObjProfesor&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjProfesor> buscar ()
    {
        this.tracer.debug("DaoProfesor", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjProfesor> lista = null;

        try
        {
            String query = "SELECT * FROM PROFESORES";
            ConsultaProfesor result = new ConsultaProfesor();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoProfesor", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoProfesor", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
