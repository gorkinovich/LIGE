//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import com.sgu.objs.ObjCurso;
import java.sql.ResultSet;
import java.util.LinkedList;
import com.sgu.util.Tracer;

/**
 * <p>Title: com.sgu.daos.ConsultaCurso</p>
 * <p>Description: Objeto para obtener una consulta de cursos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ConsultaCurso implements IConsulta
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public ConsultaCurso ()
    {
        this.tracer = new Tracer();
        this.lista = new LinkedList<ObjCurso>();
        this.tracer.debug("ConsultaCurso", "ConsultaCurso()", "Objeto creado.");
    }

    /**
     * Metodo para obtener los resultados de una consulta.
     * @param result Resultado del que obtendremos los datos de la consulta.
     */
    public void getResultSetData (ResultSet result)
    {
        int id, universidad, facultad; String nombre;
        this.tracer.debug("ConsultaCurso", "getResultSetData()", "Iniciando la lectura de la consulta...");

        try
        {
            this.lista.clear();

            while(result.next())
            {
                id = result.getInt("ID");
                universidad = result.getInt("UNIVERSIDAD");
                facultad = result.getInt("FACULTAD");
                nombre = result.getString("NOMBRE");
                this.lista.add(new ObjCurso(id, universidad, facultad, nombre));
            }
        }
        catch(Exception e)
        {
            this.tracer.error("ConsultaCurso", "getResultSetData()", e.getMessage());
        }
        this.tracer.debug("ConsultaCurso", "getResultSetData()", "Lectura de la consulta finalizada.");
    }

    /**
     * Metodo para obtener la lista con los resultados.
     * @return LinkedList&lt;ObjCurso&gt; La lista con los valores de la consulta.
     */
    public LinkedList<ObjCurso> getLista ()
    {
        return this.lista;
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private LinkedList<ObjCurso> lista;
}
