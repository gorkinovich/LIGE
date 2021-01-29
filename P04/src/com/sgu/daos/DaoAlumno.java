//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjAlumno;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoAlumno</p>
 * <p>Description: Objeto para acceder a los datos de un alumno.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoAlumno
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoAlumno ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoAlumno", "DaoAlumno()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar un alumno en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjAlumno obj)
    {
        this.tracer.debug("DaoAlumno", "insertar()", "Iniciando la inserción...");
        String valores = obj.getDNI() + ", " + obj.getUniversidad() + ", " +
                         obj.getFacultad() + ", '" + obj.getNombre() + "'" +
                         ", '" + obj.getApellidos() + "'";
        this.util.insertar("ALUMNOS", valores);
        this.tracer.debug("DaoAlumno", "insertar()", "Insercion finalizada.");
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
        this.tracer.debug("DaoAlumno", "eliminar()", "Iniciando eliminación...");
        String condicion = "DNI=" + dni + " AND UNIVERSIDAD=" + universidad +
                           " AND FACULTAD=" + facultad;
        this.util.eliminar("ALUMNOS", condicion);
        this.tracer.debug("DaoAlumno", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar un alumno en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjAlumno obj)
    {
        this.tracer.debug("DaoAlumno", "actualizar()", "Iniciando la modificación...");
        String condicion = "DNI=" + obj.getDNI() + " AND UNIVERSIDAD=" + obj.getUniversidad() +
                           " AND FACULTAD=" + obj.getFacultad();
        String valores = "NOMBRE='" + obj.getNombre() + "', APELLIDOS='" + obj.getApellidos() + "'";
        this.util.modificar("ALUMNOS", valores, condicion);
        this.tracer.debug("DaoAlumno", "actualizar()", "Modificación finalizada.");
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
        this.tracer.debug("DaoAlumno", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM ALUMNOS WHERE DNI=" + dni +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaAlumno result = new ConsultaAlumno();
            this.util.consultar(query, result);

            LinkedList<ObjAlumno> lista = result.getLista();
            for(ObjAlumno regact : lista)
            {
                if((regact.getDNI() != 0) && (dni == regact.getDNI()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoAlumno", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAlumno", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoAlumno", "existe()", "busqueda finalizada.");
        return existe;
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
        this.tracer.debug("DaoAlumno", "buscar()", "Iniciando la consulta...");
        ObjAlumno obj = null;

        try
        {
            String query = "SELECT * FROM ALUMNOS WHERE DNI=" + dni +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaAlumno result = new ConsultaAlumno();
            this.util.consultar(query, result);

            LinkedList<ObjAlumno> lista = result.getLista();
            for(ObjAlumno regact : lista)
            {
                if((regact.getDNI() != 0) && (dni == regact.getDNI()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoAlumno", "buscar()", "La consulta no es nula.");
                    obj = new ObjAlumno(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAlumno", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoAlumno", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener un alumno en la base de datos.
     * @return LinkedList&lt;ObjAlumno&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjAlumno> buscar ()
    {
        this.tracer.debug("DaoAlumno", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjAlumno> lista = null;

        try
        {
            String query = "SELECT * FROM ALUMNOS";
            ConsultaAlumno result = new ConsultaAlumno();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAlumno", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoAlumno", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
