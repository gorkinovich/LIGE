//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjAdministrativo;
import java.sql.ResultSet;
import java.util.LinkedList;
import com.sgu.util.Tracer;

/**
 * <p>Title: com.sgu.daos.ConsultaAdministrativo</p>
 * <p>Description: Objeto para obtener una consulta de administrativos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ConsultaAdministrativo implements IConsulta
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public ConsultaAdministrativo ()
    {
        this.tracer = new Tracer();
        this.lista = new LinkedList<ObjAdministrativo>();
        this.tracer.debug("ConsultaAdministrativo", "ConsultaAdministrativo()", "Objeto creado.");
    }

    /**
     * Metodo para obtener los resultados de una consulta.
     * @param result Resultado del que obtendremos los datos de la consulta.
     */
    public void getResultSetData (ResultSet result)
    {
        int dni, universidad, facultad; String nombre, apellidos;
        this.tracer.debug("ConsultaAdministrativo", "getResultSetData()", "Iniciando la lectura de la consulta...");

        try
        {
            this.lista.clear();

            while(result.next())
            {
                dni = result.getInt("DNI");
                universidad = result.getInt("UNIVERSIDAD");
                facultad = result.getInt("FACULTAD");
                nombre = result.getString("NOMBRE");
                apellidos = result.getString("APELLIDOS");
                this.lista.add(new ObjAdministrativo(dni, universidad, facultad, nombre, apellidos));
            }
        }
        catch(Exception e)
        {
            this.tracer.error("ConsultaAdministrativo", "getResultSetData()", e.getMessage());
        }
        this.tracer.debug("ConsultaAdministrativo", "getResultSetData()", "Lectura de la consulta finalizada.");
    }

    /**
     * Metodo para obtener la lista con los resultados.
     * @return LinkedList&lt;ObjAdministrativo&gt; La lista con los valores de la consulta.
     */
    public LinkedList<ObjAdministrativo> getLista ()
    {
        return this.lista;
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private LinkedList<ObjAdministrativo> lista;
}
