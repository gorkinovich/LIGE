//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.daos;
import java.sql.ResultSet;

/**
 * <p>Title: com.sgu.daos.IConsulta</p>
 * <p>Description: Interfaz para recoger datos de la base de datos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public interface IConsulta
{
    /**
     * Metodo para obtener los valores de una consulta.
     * @param result Resultado del que obtendremos los datos de la consulta.
     */
    void getResultSetData (ResultSet result);
}
