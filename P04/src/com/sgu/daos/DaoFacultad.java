//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjFacultad;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoFacultad</p>
 * <p>Description: Objeto para acceder a los datos de una facultad.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoFacultad
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoFacultad ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoFacultad", "DaoFacultad()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar una facultad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjFacultad obj)
    {
        this.tracer.debug("DaoFacultad", "insertar()", "Iniciando la inserción...");
        String valores = obj.getID() + ", " + obj.getUniversidad() + ",' " +
                         obj.getNombre() + "', '" + obj.getDireccion() + "'";
        this.util.insertar("FACULTADES", valores);
        this.tracer.debug("DaoFacultad", "insertar()", "Insercion finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para eliminar una facultad en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     */
    public void eliminar (int id, int universidad)
    {
        this.tracer.debug("DaoFacultad", "eliminar()", "Iniciando eliminación...");
        String condicion = "ID=" + id + " AND UNIVERSIDAD=" + universidad;
        this.util.eliminar("FACULTADES", condicion);
        this.tracer.debug("DaoFacultad", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar una facultad en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjFacultad obj)
    {
        this.tracer.debug("DaoFacultad", "actualizar()", "Iniciando la modificación...");
        String condicion = "ID=" + obj.getID() + " AND UNIVERSIDAD=" + obj.getUniversidad();
        String valores = "NOMBRE='" + obj.getNombre() + "', DIRECCION='" + obj.getDireccion() + "'";
        this.util.modificar("FACULTADES", valores, condicion);
        this.tracer.debug("DaoFacultad", "actualizar()", "Modificación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para saber si está una facultad en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int id, int universidad)
    {
        this.tracer.debug("DaoFacultad", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM FACULTADES WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad;
            ConsultaFacultad result = new ConsultaFacultad();
            this.util.consultar(query, result);

            LinkedList<ObjFacultad> lista = result.getLista();
            for(ObjFacultad regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()))
                {
                    this.tracer.debug("DaoFacultad", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoFacultad", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoFacultad", "existe()", "busqueda finalizada.");
        return existe;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener una facultad en la base de datos.
     * @param id          ID del elemento.
     * @param universidad ID de la universidad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjFacultad buscar (int id, int universidad)
    {
        this.tracer.debug("DaoFacultad", "buscar()", "Iniciando la consulta...");
        ObjFacultad obj = null;

        try
        {
            String query = "SELECT * FROM FACULTADES WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad;
            ConsultaFacultad result = new ConsultaFacultad();
            this.util.consultar(query, result);

            LinkedList<ObjFacultad> lista = result.getLista();
            for(ObjFacultad regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()))
                {
                    this.tracer.debug("DaoFacultad", "buscar()", "La consulta no es nula.");
                    obj = new ObjFacultad(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoFacultad", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoFacultad", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener una facultad en la base de datos.
     * @return LinkedList&lt;ObjFacultad&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjFacultad> buscar ()
    {
        this.tracer.debug("DaoFacultad", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjFacultad> lista = null;

        try
        {
            String query = "SELECT * FROM FACULTADES";
            ConsultaFacultad result = new ConsultaFacultad();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoFacultad", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoFacultad", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
