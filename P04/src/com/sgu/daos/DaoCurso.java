//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjCurso;
import com.sgu.daos.DaoUtil;
import com.sgu.util.Tracer;
import java.util.LinkedList;

/**
 * <p>Title: com.sgu.daos.DaoCurso</p>
 * <p>Description: Objeto para acceder a los datos de un curso.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class DaoCurso
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoCurso ()
    {
        this.tracer = new Tracer();
        this.util = new DaoUtil();
        this.tracer.debug("DaoCurso", "DaoCurso()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar un curso en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void insertar (ObjCurso obj)
    {
        this.tracer.debug("DaoCurso", "insertar()", "Iniciando la inserción...");
        String valores = obj.getID() + ", " + obj.getUniversidad() + ", " +
                         obj.getFacultad() + ", '" + obj.getNombre() + "'";
        this.util.insertar("CURSOS", valores);
        this.tracer.debug("DaoCurso", "insertar()", "Insercion finalizada.");
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
        this.tracer.debug("DaoCurso", "eliminar()", "Iniciando eliminación...");
        String condicion = "ID=" + id + " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
        this.util.eliminar("CURSOS", condicion);
        this.tracer.debug("DaoCurso", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar un curso en la base de datos.
     * @param obj Objeto con los datos del elemento.
     */
    public void modificar (ObjCurso obj)
    {
        this.tracer.debug("DaoCurso", "actualizar()", "Iniciando la modificación...");
        String condicion = "ID=" + obj.getID() + " AND UNIVERSIDAD=" + obj.getUniversidad() +
                           " AND FACULTAD=" + obj.getFacultad();
        String valores = "NOMBRE='" + obj.getNombre() + "'";
        this.util.modificar("CURSOS", valores, condicion);
        this.tracer.debug("DaoCurso", "actualizar()", "Modificación finalizada.");
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
        this.tracer.debug("DaoCurso", "existe()", "Iniciando la busqueda...");
        boolean existe = false;

        try
        {
            String query = "SELECT * FROM CURSOS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaCurso result = new ConsultaCurso();
            this.util.consultar(query, result);

            LinkedList<ObjCurso> lista = result.getLista();
            for(ObjCurso regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoCurso", "existe()", "La consulta no es nula.");
                    existe = true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoCurso", "existe()", e.getMessage());
        }

        this.tracer.debug("DaoCurso", "existe()", "busqueda finalizada.");
        return existe;
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
        this.tracer.debug("DaoCurso", "buscar()", "Iniciando la consulta...");
        ObjCurso obj = null;

        try
        {
            String query = "SELECT * FROM CURSOS WHERE ID=" + id +
                           " AND UNIVERSIDAD=" + universidad + " AND FACULTAD=" + facultad;
            ConsultaCurso result = new ConsultaCurso();
            this.util.consultar(query, result);

            LinkedList<ObjCurso> lista = result.getLista();
            for(ObjCurso regact : lista)
            {
                if((regact.getID() != 0) && (id == regact.getID()) &&
                   (regact.getUniversidad() != 0) && (universidad == regact.getUniversidad()) &&
                   (regact.getFacultad() != 0) && (facultad == regact.getFacultad()))
                {
                    this.tracer.debug("DaoCurso", "buscar()", "La consulta no es nula.");
                    obj = new ObjCurso(regact);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            this.tracer.error("DaoCurso", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoCurso", "buscar()", "Busqueda finalizada.");
        return obj;
    }


    //-----------------------------------------------------------------------
    /**
     * Método para obtener un curso en la base de datos.
     * @return LinkedList&lt;ObjCurso&gt; Una lista con todos los elementos de la tabla.
     */
    public LinkedList<ObjCurso> buscar ()
    {
        this.tracer.debug("DaoCurso", "buscar()", "Iniciando la consulta...");
        LinkedList<ObjCurso> lista = null;

        try
        {
            String query = "SELECT * FROM CURSOS";
            ConsultaCurso result = new ConsultaCurso();
            this.util.consultar(query, result);
            lista = result.getLista();
        }
        catch(Exception e)
        {
            this.tracer.error("DaoCurso", "buscar()", e.getMessage());
        }

        this.tracer.debug("DaoCurso", "buscar()", "Busqueda finalizada.");
        return lista;
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private DaoUtil util;
}
