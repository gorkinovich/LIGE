//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.objs;

/**
 * <p>Title: com.sgu.objs.ObjFacultad</p>
 * <p>Description: Objeto para almacenar los datos de una facultad.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ObjFacultad
{
    //-----------------------------------------------------------------------
    // Zona pública de la clase.
    //-----------------------------------------------------------------------
    /**
     * Constructor de la clase.
     */
    public ObjFacultad ()
    {
        this.id = 0;
        this.universidad = 0;
        this.nombre = "";
        this.direccion = "";
    }

    /**
     * Constructor de la clase.
     * @param id          ID de la facultad.
     * @param universidad ID de la universidad de la facultad.
     * @param nombre      Nombre de la facultad.
     * @param direccion   Dirección de la facultad.
     */
    public ObjFacultad (int id, int universidad, String nombre, String direccion)
    {
        this.id = id;
        this.universidad = universidad;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Constructor de la clase.
     * @param obj Objeto a copiar.
     */
    public ObjFacultad (ObjFacultad obj)
    {
        this.id = obj.id;
        this.universidad = obj.universidad;
        this.nombre = obj.nombre;
        this.direccion = obj.direccion;
    }

    //-----------------------------------------------------------------------
    // Gets.
    //-----------------------------------------------------------------------
    /**
     * Método para obtener el valor del campo ID.
     * @return int Devuelve el valor del campo ID.
     */
    public int getID ()
    {
        return this.id;
    }

    /**
     * Método para obtener el valor del campo universidad.
     * @return int Devuelve el valor del campo universidad.
     */
    public int getUniversidad ()
    {
        return this.universidad;
    }

    /**
     * Método para obtener el valor del campo nombre.
     * @return String Devuelve el valor del campo nombre.
     */
    public String getNombre ()
    {
        return this.nombre;
    }

    /**
     * Método para obtener el valor del campo direccion.
     * @return String Devuelve el valor del campo direccion.
     */
    public String getDireccion ()
    {
        return direccion;
    }

    //-----------------------------------------------------------------------
    // Sets.
    //-----------------------------------------------------------------------
    /**
     * Método para establecer el valor del campo ID.
     * @param value int Valor que queremos asignarle al campo.
     */
    public void setID (int value)
    {
        this.id = value;
    }

    /**
     * Método para establecer el valor del campo universidad.
     * @param value int Valor que queremos asignarle al campo.
     */
    public void setUniversidad (int value)
    {
        this.universidad = value;
    }

    /**
     * Método para establecer el valor del campo nombre.
     * @param value String Valor que queremos asignarle al campo.
     */
    public void setNombre (String value)
    {
        this.nombre = value;
    }

    /**
     * Método para establecer el valor del campo direccion.
     * @param value String Valor que queremos asignarle al campo.
     */
    public void setDireccion (String value)
    {
        this.direccion = value;
    }

    //-----------------------------------------------------------------------
    // Zona privada de la clase.
    //-----------------------------------------------------------------------
    private int id;
    private int universidad;
    private String nombre;
    private String direccion;
}
