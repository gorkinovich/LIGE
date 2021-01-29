//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjAsignatura;
import java.sql.ResultSet;
import java.util.LinkedList;
import com.sgu.util.Tracer;

/**
 * <p>Title: com.sgu.daos.ConsultaAsignatura</p>
 * <p>Description: Objeto para obtener una consulta de asignaturas.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ConsultaAsignatura implements IConsulta
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public ConsultaAsignatura ()
    {
        this.tracer = new Tracer();
        this.lista = new LinkedList<ObjAsignatura>();
        this.tracer.debug("ConsultaAsignatura", "ConsultaAsignatura()", "Objeto creado.");
    }

    /**
     * Metodo para obtener los resultados de una consulta.
     * @param result Resultado del que obtendremos los datos de la consulta.
     */
    public void getResultSetData (ResultSet result)
    {
        int id, universidad, facultad, departamento; String nombre;
        this.tracer.debug("ConsultaAsignatura", "getResultSetData()", "Iniciando la lectura de la consulta...");

        try
        {
            this.lista.clear();

            while(result.next())
            {
                id = result.getInt("ID");
                universidad = result.getInt("UNIVERSIDAD");
                facultad = result.getInt("FACULTAD");
                departamento = result.getInt("departamento");
                nombre = result.getString("NOMBRE");
                this.lista.add(new ObjAsignatura(id, universidad, facultad, departamento, nombre));
            }
        }
        catch(Exception e)
        {
            this.tracer.error("ConsultaAsignatura", "getResultSetData()", e.getMessage());
        }
        this.tracer.debug("ConsultaAsignatura", "getResultSetData()", "Lectura de la consulta finalizada.");
    }

    /**
     * Metodo para obtener la lista con los resultados.
     * @return LinkedList&lt;ObjAsignatura&gt; La lista con los valores de la consulta.
     */
    public LinkedList<ObjAsignatura> getLista ()
    {
        return this.lista;
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private LinkedList<ObjAsignatura> lista;
}
