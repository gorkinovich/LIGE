//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjAsignatura;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoAsignatura</p>
 * <p>Description: Objeto para acceder a los datos de una asignatura.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoAsignatura
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoAsignatura ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoAsignatura", "DaoAsignatura()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar una asignatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjAsignatura obj)
    {
        this.tracer.debug("DaoAsignatura", "insertar()", "Iniciando la inserción...");
        String valores = obj.getID() + ", " + obj.getUniversidad() + ", " +
                         obj.getFacultad() + ", " + obj.getDepartamento() +
                         ", '" + obj.getNombre() + "'";
        this.util.insertar("ASIGNATURAS", valores);
        this.tracer.debug("DaoAsignatura", "insertar()", "Insercion finalizada.");
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
        this.tracer.debug("DaoAsignatura", "eliminar()", "Iniciando eliminación...");
        String condicion = "ID=" + id + " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
        this.util.eliminar("ASIGNATURAS", condicion);
        this.tracer.debug("DaoAsignatura", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar una asignatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjAsignatura obj)
    {
        this.tracer.debug("DaoAsignatura", "actualizar()", "Iniciando la modificación...");
        String condicion = "ID=" + obj.getID() + " AND UNIVERSIDAD=" + obj.getUniversidad() +
                           " AND FACULTAD=" + obj.getFacultad();
        String valores = "NOMBRE='" + obj.getNombre() + "', DEPARTAMENTO=" + obj.getDepartamento();
        this.util.modificar("ASIGNATURAS", valores, condicion);
        this.tracer.debug("DaoAsignatura", "actualizar()", "Modificación finalizada.");
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
        this.tracer.debug("DaoAsignatura", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM ASIGNATURAS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaAsignatura result = new ConsultaAsignatura();
            this.util.consultar(query, result);

            LinkedList<ObjAsignatura> lista = result.getLista();
            for(ObjAsignatura regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoAsignatura", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAsignatura", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoAsignatura", "existe()", "busqueda finalizada.");
        return existe;
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
        this.tracer.debug("DaoAsignatura", "buscar()", "Iniciando la consulta...");
        ObjAsignatura obj = null;

        try
        {
            String query = "SELECT * FROM ASIGNATURAS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaAsignatura result = new ConsultaAsignatura();
            this.util.consultar(query, result);

            LinkedList<ObjAsignatura> lista = result.getLista();
            for(ObjAsignatura regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoAsignatura", "buscar()", "La consulta no es nula.");
                    obj = new ObjAsignatura(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAsignatura", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoAsignatura", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener una asignatura en la base de datos.
     * @return LinkedList&lt;ObjAsignatura&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjAsignatura> buscar ()
    {
        this.tracer.debug("DaoAsignatura", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjAsignatura> lista = null;

        try
        {
            String query = "SELECT * FROM ASIGNATURAS";
            ConsultaAsignatura result = new ConsultaAsignatura();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAsignatura", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoAsignatura", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
