//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjUniversidad;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoUniversidad</p>
 * <p>Description: Objeto para acceder a los datos de una universidad.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoUniversidad
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoUniversidad ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoUniversidad", "DaoUniversidad()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar una universidad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjUniversidad obj)
    {
        this.tracer.debug("DaoUniversidad", "insertar()", "Iniciando la inserción...");
        String valores = obj.getID() + ", '" + obj.getNombre() + "', '" + obj.getDireccion() + "'";
        this.util.insertar("UNIVERSIDADES", valores);
        this.tracer.debug("DaoUniversidad", "insertar()", "Insercion finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para eliminar una universidad en la base de datos.
     * @param id ID del elemento.
     */
    public void eliminar (int id)
    {
        this.tracer.debug("DaoUniversidad", "eliminar()", "Iniciando eliminación...");
        String condicion = "ID=" + id;
        this.util.eliminar("UNIVERSIDADES", condicion);
        this.tracer.debug("DaoUniversidad", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar una universidad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjUniversidad obj)
    {
        this.tracer.debug("DaoUniversidad", "actualizar()", "Iniciando la modificación...");
        String condicion = "ID=" + obj.getID();
        String valores = "NOMBRE='" + obj.getNombre() + "', DIRECCION='" + obj.getDireccion() + "'";
        this.util.modificar("UNIVERSIDADES", valores, condicion);
        this.tracer.debug("DaoUniversidad", "actualizar()", "Modificación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para saber si está una universidad en la base de datos.
     * @param id ID del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id)
    {
        this.tracer.debug("DaoUniversidad", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM UNIVERSIDADES WHERE ID=" + id;
            ConsultaUniversidad result = new ConsultaUniversidad();
            this.util.consultar(query, result);

            LinkedList<ObjUniversidad> lista = result.getLista();
            for(ObjUniversidad regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()))
                {
                    this.tracer.debug("DaoUniversidad", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoUniversidad", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoUniversidad", "existe()", "busqueda finalizada.");
        return existe;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener una universidad en la base de datos.
     * @param id ID del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjUniversidad buscar (int id)
    {
        this.tracer.debug("DaoUniversidad", "buscar()", "Iniciando la consulta...");
        ObjUniversidad obj = null;

        try
        {
            String query = "SELECT * FROM UNIVERSIDADES WHERE ID=" + id;
            ConsultaUniversidad result = new ConsultaUniversidad();
            this.util.consultar(query, result);

            LinkedList<ObjUniversidad> lista = result.getLista();
            for(ObjUniversidad regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()))
                {
                    this.tracer.debug("DaoUniversidad", "buscar()", "La consulta no es nula.");
                    obj = new ObjUniversidad(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoUniversidad", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoUniversidad", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener una universidad en la base de datos.
     * @return LinkedList&lt;ObjUniversidad&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjUniversidad> buscar ()
    {
        this.tracer.debug("DaoUniversidad", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjUniversidad> lista = null;

        try
        {
            String query = "SELECT * FROM UNIVERSIDADES";
            ConsultaUniversidad result = new ConsultaUniversidad();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoUniversidad", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoUniversidad", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
