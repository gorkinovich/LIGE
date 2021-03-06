//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.objs;

/**
 * <p>Title: com.sgu.objs.ObjCurso</p>
 * <p>Description: Objeto para almacenar los datos de un curso.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ObjCurso
{
    //-----------------------------------------------------------------------
    // Zona pública de la clase.
    //-----------------------------------------------------------------------
    /**
     * Constructor de la clase.
     */
    public ObjCurso ()
    {
        this.id = 0;
        this.universidad = 0;
        this.facultad = 0;
        this.nombre = "";
    }

    /**
     * Constructor de la clase.
     * @param id          ID del curso.
     * @param universidad ID de la universidad del curso.
     * @param facultad    ID de la facultad del curso.
     * @param nombre      Nombre del curso.
     */
    public ObjCurso (int id, int universidad, int facultad, String nombre)
    {
        this.id = id;
        this.universidad = universidad;
        this.facultad = facultad;
        this.nombre = nombre;
    }

    /**
     * Constructor de la clase.
     * @param obj Objeto a copiar.
     */
    public ObjCurso (ObjCurso obj)
    {
        this.id = obj.id;
        this.universidad = obj.universidad;
        this.facultad = obj.facultad;
        this.nombre = obj.nombre;
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
     * Método para obtener el valor del campo facultad.
     * @return int Devuelve el valor del campo facultad.
     */
    public int getFacultad ()
    {
        return this.facultad;
    }

    /**
     * Método para obtener el valor del campo nombre.
     * @return String Devuelve el valor del campo nombre.
     */
    public String getNombre ()
    {
        return this.nombre;
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
     * Método para establecer el valor del campo facultad.
     * @param value int Valor que queremos asignarle al campo.
     */
    public void setFacultad (int value)
    {
        this.facultad = value;
    }

    /**
     * Método para establecer el valor del campo nombre.
     * @param value String Valor que queremos asignarle al campo.
     */
    public void setNombre (String value)
    {
        this.nombre = value;
    }

    //-----------------------------------------------------------------------
    // Zona privada de la clase.
    //-----------------------------------------------------------------------
    private int id;
    private int universidad;
    private int facultad;
    private String nombre;
}
