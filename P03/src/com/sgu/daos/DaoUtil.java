//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.sgu.util.Tracer;

/**
 * <p>Title: com.sgu.daos.DaoUtil</p>
 * <p>Description: Objeto para manejar la base de datos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public final class DaoUtil
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    /**
     * Constructor de la clase.
     */
    public DaoUtil ()
    {
        this.tracer = new Tracer();
        this.tracer.debug("DaoUtil", "DaoUtil()", "Objeto creado.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para insertar un dato en la base de datos.
     * @param tabla   Tabla que queremos manejar.
     * @param valores Los valores que queremos insertar.
     */
    public void insertar (String tabla, String valores)
    {
        // Primero declaramos unas cuantas variables.
        this.tracer.debug("DaoUtil", "insertar()", "Iniciando la inserción...");
        Connection connection = null;
        Statement statement = null;
        String query = "INSERT INTO " + tabla + " VALUES (" + valores + ")";

        try
        {
            // Ahora creamos la conexión y un objeto para ejecutar consultas.
            this.tracer.debug("DaoUtil", "insertar()", "Comienza la inserción...");
            connection = this.openConnection();
            statement = connection.createStatement();

            // Ejecutamos la consulta a la espera del resultado.
            this.tracer.debug("DaoUtil", "insertar()", "Comienza la query: " + query + ";");
            int num = statement.executeUpdate(query);
            this.tracer.debug("DaoUtil", "insertar()", "Se han añadido " + num + " filas.");
        }
        catch(Exception e)
        {
            this.tracer.error("DaoUtil", "insertar()", e.getMessage());
        }
        finally
        {
            // Y finalmente cerramos la conexión.
            if(connection != null)
            {
                this.closeConnection(connection);
                this.tracer.debug("DaoUtil", "insertar()", "Conexión cerrada.");
            }
        }

        this.tracer.debug("DaoUtil", "insertar()", "Insercion finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para eliminar un dato en la base de datos.
     * @param tabla     Tabla que queremos manejar.
     * @param condicion Condición para la eliminación.
     */
    public void eliminar (String tabla, String condicion)
    {
        // Primero declaramos unas cuantas variables.
        this.tracer.debug("DaoUtil", "eliminar()", "Iniciando la eliminación...");
        Connection connection = null;
        Statement statement = null;
        String query = "DELETE FROM " + tabla + " WHERE " + condicion;

        try
        {
            // Ahora creamos la conexión y un objeto para ejecutar consultas.
            this.tracer.debug("DaoUtil", "eliminar()", "Comienza la eliminación...");
            connection = this.openConnection();
            statement = connection.createStatement();

            // Ejecutamos la consulta a la espera del resultado.
            this.tracer.debug("DaoUtil", "eliminar()", "Comienza la query: " + query + ";");
            int num = statement.executeUpdate(query);
            this.tracer.debug("DaoUtil", "eliminar()", "Se han eliminado " + num + " filas.");
        }
        catch(Exception e)
        {
            this.tracer.error("DaoUtil", "eliminar()", e.getMessage());
        }
        finally
        {
            // Y finalmente cerramos la conexión.
            if(connection != null)
            {
                this.closeConnection(connection);
                this.tracer.debug("DaoUtil", "eliminar()", "Conexión cerrada.");
            }
        }

        this.tracer.debug("DaoUtil", "eliminar()", "Eliminación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para modificar un dato en la base de datos.
     * @param tabla     Tabla que queremos manejar.
     * @param valores   Los valores que queremos modificar.
     * @param condicion Condición para la modificación.
     */
    public void modificar (String tabla, String valores, String condicion)
    {
        // Primero declaramos unas cuantas variables.
        this.tracer.debug("DaoUtil", "modificar()", "Iniciando la modificación...");
        Connection connection = null;
        Statement statement = null;
        String query = "UPDATE " + tabla + " SET " + valores + " WHERE " + condicion;

        try
        {
            // Ahora creamos la conexión y un objeto para ejecutar consultas.
            this.tracer.debug("DaoUtil", "modificar()", "Comienza la modificación...");
            connection = this.openConnection();
            statement = connection.createStatement();

            // Ejecutamos la consulta a la espera del resultado.
            this.tracer.debug("DaoUtil", "modificar()", "Comienza la query: " + query + ";");
            int num = statement.executeUpdate(query);
            this.tracer.debug("DaoUtil", "modificar()", "Se han modificado " + num + " filas.");
        }
        catch(Exception e)
        {
            this.tracer.error("DaoUtil", "modificar()", e.getMessage());
        }
        finally
        {
            // Y finalmente cerramos la conexión.
            if(connection != null)
            {
                this.closeConnection(connection);
                this.tracer.debug("DaoUtil", "modificar()", "Conexión cerrada.");
            }
        }

        this.tracer.debug("DaoUtil", "modificar()", "Modificación finalizada.");
    }


    //-----------------------------------------------------------------------
    /**
     * Método para consultar un dato en la base de datos.
     * @param query      Consulta que deseamos realizar.
     * @param contenedor Objeto donde se va a almacenar los datos.
     */
    public void consultar (String query, IConsulta contenedor)
    {
        // Primero declaramos unas cuantas variables.
        this.tracer.debug("DaoUtil", "consultar()", "Iniciando la consulta...");
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        this.tracer.debug("DaoUtil", "consultar()", "Empieza la busqueda...");
        try
        {
            // Ahora creamos la conexión y un objeto para ejecutar consultas.
            this.tracer.debug("DaoUtil", "consultar()", "Abriendo conexión...");
            connection = this.openConnection();
            statement = connection.createStatement();

            // Ejecutamos la consulta a la espera del resultado.
            this.tracer.debug("DaoUtil", "consultar()", "Comienza la query: " + query + ";");
            result = statement.executeQuery(query);
            contenedor.getResultSetData(result);
        }
        catch(Exception e)
        {
            this.tracer.error("DaoUtil", "consultar()", e.getMessage());
        }
        finally
        {
            // Y finalmente cerramos la conexión.
            if(connection != null)
            {
                this.closeConnection(connection);
                this.tracer.debug("DaoUtil", "consultar()", "Conexión cerrada.");
            }
        }

        this.tracer.debug("DaoUtil", "consultar()", "Consulta finalizada.");
    }


    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    /**
     * Metodo para abrir una conexión contra la base de datos.
     * @return Devuelve una conexión abierta contra la base de datos.
     */
    private Connection openConnection ()
    {
        Connection connection = null;
        try {
            Class.forName(this.DRIVER);
            connection = DriverManager.getConnection(this.URL, "root", "root");
            this.tracer.debug("DaoUtil", "openConnection()", "Conexión abierta.");
        } catch (Exception e) {
            this.tracer.error("DaoUtil", "openConnection()", e.getMessage());
        }

        return connection;
    }


    //-----------------------------------------------------------------------
    /**
     * Metodo para cerrar una conexión contra la base de datos.
     * @param connection Conexión que queremos cerrar.
     */
    private void closeConnection (Connection connection)
    {
        try {
            connection.close();
            this.tracer.debug("DaoUtil", "closeConnection()", "Conexión cerrada.");
        } catch (SQLException sqle) {
            this.tracer.error("DaoUtil", "closeConnection()", sqle.getMessage());
        }
    }


    //-----------------------------------------------------------------------
    // Variables privadas.
    //-----------------------------------------------------------------------
    private Tracer tracer;
    private final String DRIVER = "com.borland.datastore.jdbc.DataStoreDriver";
    private final String URL    = "jdbc:borland:dslocal:c:/Lessman/UCM/LIGE/SGU-PC/DataStore/SGU.jds";
    //private final String URL  = "jdbc:borland:dslocal:c:/JBuilder9/samples/JDataStore/datastores/SGU.jds";
}
