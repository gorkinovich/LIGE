//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.objs;

/**
 * <p>Title: com.sgu.objs.ObjAsignatura</p>
 * <p>Description: Objeto para almacenar los datos de una asignatura.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ObjAsignatura
{
    //-----------------------------------------------------------------------
    // Zona pública de la clase.
    //-----------------------------------------------------------------------
    /**
     * Constructor de la clase.
     */
    public ObjAsignatura ()
    {
        this.id = 0;
        this.universidad = 0;
        this.facultad = 0;
        this.departamento = 0;
        this.nombre = "";
    }

    /**
     * Constructor de la clase.
     * @param id           ID de la asignatura.
     * @param universidad  ID de la universidad de la asignatura.
     * @param facultad     ID de la facultad de la asignatura.
     * @param departamento ID de la facultad de la asignatura.
     * @param nombre       Nombre de la asignatura.
     */
    public ObjAsignatura (int id, int universidad, int facultad,
            int departamento, String nombre)
    {
        this.id = id;
        this.universidad = universidad;
        this.facultad = facultad;
        this.departamento = departamento;
        this.nombre = nombre;
    }

    /**
     * Constructor de la clase.
     * @param obj Objeto a copiar.
     */
    public ObjAsignatura (ObjAsignatura obj)
    {
        this.id = obj.id;
        this.universidad = obj.universidad;
        this.facultad = obj.facultad;
        this.departamento = obj.departamento;
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
     * Método para obtener el valor del campo departamento.
     * @return int Devuelve el valor del campo departamento.
     */
    public int getDepartamento ()
    {
        return departamento;
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
     * Método para establecer el valor del campo departamento.
     * @param value int Valor que queremos asignarle al campo.
     */
    public void setDepartamento (int value)
    {
        this.departamento = value;
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
    private int departamento;
    private String nombre;
}
