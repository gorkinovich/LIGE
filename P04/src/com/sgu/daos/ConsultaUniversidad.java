//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjUniversidad;
import java.sql.ResultSet;
import java.util.LinkedList;
import com.sgu.util.Tracer;

/**
 * <p>Title: com.sgu.daos.ConsultaUniversidad</p>
 * <p>Description: Objeto para obtener una consulta de universidades.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ConsultaUniversidad implements IConsulta
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public ConsultaUniversidad ()
    {
        this.tracer = new Tracer();
        this.lista = new LinkedList<ObjUniversidad>();
        this.tracer.debug("ConsultaUniversidad", "ConsultaUniversidad()", "Objeto creado.");
    }

    /**
     * Metodo para obtener los resultados de una consulta.
     * @param result Resultado del que obtendremos los datos de la consulta.
     */
    public void getResultSetData (ResultSet result)
    {
        int id; String nombre, direccion;
        this.tracer.debug("ConsultaUniversidad", "getResultSetData()", "Iniciando la lectura de la consulta...");

        try
        {
            this.lista.clear();

            while(result.next())
            {
                id = result.getInt("ID");
                nombre = result.getString("NOMBRE");
                direccion = result.getString("DIRECCION");
                this.lista.add(new ObjUniversidad(id, nombre, direccion));
            }
        }
        catch(Exception e)
        {
            this.tracer.error("ConsultaUniversidad", "getResultSetData()", e.getMessage());
        }
        this.tracer.debug("ConsultaUniversidad", "getResultSetData()", "Lectura de la consulta finalizada.");
    }

    /**
     * Metodo para obtener la lista con los resultados.
     * @return LinkedList&lt;ObjUniversidad&gt; La lista con los valores de la consulta.
     */
    public LinkedList<ObjUniversidad> getLista ()
    {
        return this.lista;
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private LinkedList<ObjUniversidad> lista;
}
