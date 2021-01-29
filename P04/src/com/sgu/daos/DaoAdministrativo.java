//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjAdministrativo;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoAdministrador</p>
 * <p>Description: Objeto para acceder a los datos de un administrador.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoAdministrativo
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoAdministrativo ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoAdministrativo", "DaoAdministrativo()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar un administrativo en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjAdministrativo obj)
    {
        this.tracer.debug("DaoAdministrativo", "insertar()", "Iniciando la inserción...");
        String valores = obj.getDNI() + ", " + obj.getUniversidad() + ", " +
                         obj.getFacultad() + ", '" + obj.getNombre() + "'" +
                         ", '" + obj.getApellidos() + "'";
        this.util.insertar("ADMINISTRATIVOS", valores);
        this.tracer.debug("DaoAdministrativo", "insertar()", "Insercion finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un administrativo en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     */
    public void eliminar (int dni, int universidad, int facultad)
    {
        this.tracer.debug("DaoAdministrativo", "eliminar()", "Iniciando eliminación...");
        String condicion = "DNI=" + dni + " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
        this.util.eliminar("ADMINISTRATIVOS", condicion);
        this.tracer.debug("DaoAdministrativo", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar un administrativo en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjAdministrativo obj)
    {
        this.tracer.debug("DaoAdministrativo", "actualizar()", "Iniciando la modificación...");
        String condicion = "DNI=" + obj.getDNI() + " AND UNIVERSIDAD=" + obj.getUniversidad() +
                           " AND FACULTAD=" + obj.getFacultad();
        String valores = "NOMBRE='" + obj.getNombre() + "', APELLIDOS='" + obj.getApellidos() + "'";
        this.util.modificar("ADMINISTRATIVOS", valores, condicion);
        this.tracer.debug("DaoAdministrativo", "actualizar()", "Modificación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para saber si está un administrativo en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return boolean Devuelve si existe o no.
     */
    public boolean existe (int dni, int universidad, int facultad)
    {
        this.tracer.debug("DaoAdministrativo", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM ADMINISTRATIVOS WHERE DNI=" + dni +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaAdministrativo result = new ConsultaAdministrativo();
            this.util.consultar(query, result);

            LinkedList<ObjAdministrativo> lista = result.getLista();
            for(ObjAdministrativo regact : lista)
            {
                if((regact.getDNI() != 0) && (dni == regact.getDNI()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoAdministrativo", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAdministrativo", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoAdministrativo", "existe()", "busqueda finalizada.");
        return existe;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener un administrativo en la base de datos.
     * @param dni         DNI del elemento.
     * @param universidad ID de la universidad del elemento.
     * @param facultad    ID de la facultad del elemento.
     * @return Devuelve el elemento si lo encuentra.
     */
    public ObjAdministrativo buscar (int dni, int universidad, int facultad)
    {
        this.tracer.debug("DaoAdministrativo", "buscar()", "Iniciando la consulta...");
        ObjAdministrativo obj = null;

        try
        {
            String query = "SELECT * FROM ADMINISTRATIVOS WHERE DNI=" + dni +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaAdministrativo result = new ConsultaAdministrativo();
            this.util.consultar(query, result);

            LinkedList<ObjAdministrativo> lista = result.getLista();
            for(ObjAdministrativo regact : lista)
            {
                if((regact.getDNI() != 0) && (dni == regact.getDNI()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoAdministrativo", "buscar()", "La consulta no es nula.");
                    obj = new ObjAdministrativo(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAdministrativo", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoAdministrativo", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener un administrativo en la base de datos.
     * @return LinkedList&lt;ObjAdministrativo&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjAdministrativo> buscar ()
    {
        this.tracer.debug("DaoAdministrativo", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjAdministrativo> lista = null;

        try
        {
            String query = "SELECT * FROM ADMINISTRATIVOS";
            ConsultaAdministrativo result = new ConsultaAdministrativo();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoAdministrativo", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoAdministrativo", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
