//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjLicenciatura;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoLicenciatura</p>
 * <p>Description: Objeto para acceder a los datos de una licenciatura.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoLicenciatura
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoLicenciatura ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoLicenciatura", "DaoLicenciatura()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar una licenciatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjLicenciatura obj)
    {
        this.tracer.debug("DaoLicenciatura", "insertar()", "Iniciando la inserción...");
        String valores = obj.getID() + ", " + obj.getUniversidad() + ", " +
                         obj.getFacultad() + ", '" + obj.getNombre() + "'";
        this.util.insertar("LICENCIATURAS", valores);
        this.tracer.debug("DaoLicenciatura", "insertar()", "Insercion finalizada.");
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
        this.tracer.debug("DaoLicenciatura", "eliminar()", "Iniciando eliminación...");
        String condicion = "ID=" + id + " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
        this.util.eliminar("LICENCIATURAS", condicion);
        this.tracer.debug("DaoLicenciatura", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar una licenciatura en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjLicenciatura obj)
    {
        this.tracer.debug("DaoLicenciatura", "actualizar()", "Iniciando la modificación...");
        String condicion = "ID=" + obj.getID() + " AND UNIVERSIDAD=" + obj.getUniversidad() +
                           " AND FACULTAD=" + obj.getFacultad();
        String valores = "NOMBRE='" + obj.getNombre() + "'";
        this.util.modificar("LICENCIATURAS", valores, condicion);
        this.tracer.debug("DaoLicenciatura", "actualizar()", "Modificación finalizada.");
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
        this.tracer.debug("DaoLicenciatura", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM LICENCIATURAS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaLicenciatura result = new ConsultaLicenciatura();
            this.util.consultar(query, result);

            LinkedList<ObjLicenciatura> lista = result.getLista();
            for(ObjLicenciatura regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoLicenciatura", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoLicenciatura", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoLicenciatura", "existe()", "busqueda finalizada.");
        return existe;
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
        this.tracer.debug("DaoLicenciatura", "buscar()", "Iniciando la consulta...");
        ObjLicenciatura obj = null;

        try
        {
            String query = "SELECT * FROM LICENCIATURAS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaLicenciatura result = new ConsultaLicenciatura();
            this.util.consultar(query, result);

            LinkedList<ObjLicenciatura> lista = result.getLista();
            for(ObjLicenciatura regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoLicenciatura", "buscar()", "La consulta no es nula.");
                    obj = new ObjLicenciatura(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoLicenciatura", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoLicenciatura", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener una licenciatura en la base de datos.
     * @return LinkedList&lt;ObjLicenciatura&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjLicenciatura> buscar ()
    {
        this.tracer.debug("DaoLicenciatura", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjLicenciatura> lista = null;

        try
        {
            String query = "SELECT * FROM LICENCIATURAS";
            ConsultaLicenciatura result = new ConsultaLicenciatura();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoLicenciatura", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoLicenciatura", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
