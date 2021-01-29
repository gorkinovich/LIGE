//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjProfesor;
import java.sql.ResultSet;
import java.util.LinkedList;
import com.sgu.util.Tracer;

/**
 * <p>Title: com.sgu.daos.ConsultaProfesor</p>
 * <p>Description: Objeto para obtener una consulta de profesores.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ConsultaProfesor implements IConsulta
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public ConsultaProfesor ()
    {
        this.tracer = new Tracer();
        this.lista = new LinkedList<ObjProfesor>();
        this.tracer.debug("ConsultaProfesor", "ConsultaProfesor()", "Objeto creado.");
    }

    /**
     * Metodo para obtener los resultados de una consulta.
     * @param result Resultado del que obtendremos los datos de la consulta.
     */
    public void getResultSetData (ResultSet result)
    {
        int dni, universidad, facultad, departamento; String nombre, apellidos;
        this.tracer.debug("ConsultaProfesor", "getResultSetData()", "Iniciando la lectura de la consulta...");

        try
        {
            this.lista.clear();

            while(result.next())
            {
                dni = result.getInt("DNI");
                universidad = result.getInt("UNIVERSIDAD");
                facultad = result.getInt("FACULTAD");
                departamento = result.getInt("departamento");
                nombre = result.getString("NOMBRE");
                apellidos = result.getString("APELLIDOS");
                this.lista.add(new ObjProfesor(dni, universidad, facultad, departamento, nombre, apellidos));
            }
        }
        catch(Exception e)
        {
            this.tracer.error("ConsultaProfesor", "getResultSetData()", e.getMessage());
        }
        this.tracer.debug("ConsultaProfesor", "getResultSetData()", "Lectura de la consulta finalizada.");
    }

    /**
     * Metodo para obtener la lista con los resultados.
     * @return LinkedList&lt;ObjProfesor&gt; La lista con los valores de la consulta.
     */
    public LinkedList<ObjProfesor> getLista ()
    {
        return this.lista;
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private LinkedList<ObjProfesor> lista;
}
