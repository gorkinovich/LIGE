//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjFacultad;
import java.sql.ResultSet;
import java.util.LinkedList;
import com.sgu.util.Tracer;

/**
 * <p>Title: com.sgu.daos.ConsultaFacultad</p>
 * <p>Description: Objeto para obtener una consulta de facultades.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ConsultaFacultad implements IConsulta
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public ConsultaFacultad ()
    {
        this.tracer = new Tracer();
        this.lista = new LinkedList<ObjFacultad>();
        this.tracer.debug("ConsultaFacultad", "ConsultaFacultad()", "Objeto creado.");
    }

    /**
     * Metodo para obtener los resultados de una consulta.
     * @param result Resultado del que obtendremos los datos de la consulta.
     */
    public void getResultSetData (ResultSet result)
    {
        int id, universidad; String nombre, direccion;
        this.tracer.debug("ConsultaFacultad", "getResultSetData()", "Iniciando la lectura de la consulta...");

        try
        {
            this.lista.clear();

            while(result.next())
            {
                id = result.getInt("ID");
                universidad = result.getInt("UNIVERSIDAD");
                nombre = result.getString("NOMBRE");
                direccion = result.getString("DIRECCION");
                this.lista.add(new ObjFacultad(id, universidad, nombre, direccion));
            }
        }
        catch(Exception e)
        {
            this.tracer.error("ConsultaFacultad", "getResultSetData()", e.getMessage());
        }
        this.tracer.debug("ConsultaFacultad", "getResultSetData()", "Lectura de la consulta finalizada.");
    }

    /**
     * Metodo para obtener la lista con los resultados.
     * @return LinkedList&lt;ObjFacultad&gt; La lista con los valores de la consulta.
     */
    public LinkedList<ObjFacultad> getLista ()
    {
        return this.lista;
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private LinkedList<ObjFacultad> lista;
}
