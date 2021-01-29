//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjDepartamento;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoDepartamento</p>
 * <p>Description: Objeto para acceder a los datos de un departamento.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoDepartamento
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoDepartamento ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoDepartamento", "DaoDepartamento()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar un departamento en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjDepartamento obj)
    {
        this.tracer.debug("DaoDepartamento", "insertar()", "Iniciando la inserción...");
        String valores = obj.getID() + ", " + obj.getUniversidad() + ", " +
                         obj.getFacultad() + ", '" + obj.getNombre() + "'";
        this.util.insertar("DEPARTAMENTOS", valores);
        this.tracer.debug("DaoDepartamento", "insertar()", "Insercion finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un departamento en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int id, int universidad, int facultad)
    {
        this.tracer.debug("DaoDepartamento", "eliminar()", "Iniciando eliminación...");
        String condicion = "ID=" + id + " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
        this.util.eliminar("DEPARTAMENTOS", condicion);
        this.tracer.debug("DaoDepartamento", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar un departamento en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjDepartamento obj)
    {
        this.tracer.debug("DaoDepartamento", "actualizar()", "Iniciando la modificación...");
        String condicion = "ID=" + obj.getID() + " AND UNIVERSIDAD=" + obj.getUniversidad() +
                           " AND FACULTAD=" + obj.getFacultad();
        String valores = "NOMBRE='" + obj.getNombre() + "'";
        this.util.modificar("DEPARTAMENTOS", valores, condicion);
        this.tracer.debug("DaoDepartamento", "actualizar()", "Modificación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para saber si está un departamento en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id, int universidad, int facultad)
    {
        this.tracer.debug("DaoDepartamento", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM DEPARTAMENTOS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaDepartamento result = new ConsultaDepartamento();
            this.util.consultar(query, result);

            LinkedList<ObjDepartamento> lista = result.getLista();
            for(ObjDepartamento regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoDepartamento", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoDepartamento", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoDepartamento", "existe()", "busqueda finalizada.");
        return existe;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener un departamento en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjDepartamento buscar (int id, int universidad, int facultad)
    {
        this.tracer.debug("DaoDepartamento", "buscar()", "Iniciando la consulta...");
        ObjDepartamento obj = null;

        try
        {
            String query = "SELECT * FROM DEPARTAMENTOS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaDepartamento result = new ConsultaDepartamento();
            this.util.consultar(query, result);

            LinkedList<ObjDepartamento> lista = result.getLista();
            for(ObjDepartamento regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoDepartamento", "buscar()", "La consulta no es nula.");
                    obj = new ObjDepartamento(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoDepartamento", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoDepartamento", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener un departamento en la base de datos.
     * @return LinkedList&lt;ObjDepartamento&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjDepartamento> buscar ()
    {
        this.tracer.debug("DaoDepartamento", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjDepartamento> lista = null;

        try
        {
            String query = "SELECT * FROM DEPARTAMENTOS";
            ConsultaDepartamento result = new ConsultaDepartamento();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoDepartamento", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoDepartamento", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
