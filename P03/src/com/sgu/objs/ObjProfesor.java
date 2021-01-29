//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.objs;

/**
 * <p>Title: com.sgu.objs.ObjProfesor</p>
 * <p>Description: Objeto para almacenar los datos de un profesor.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class ObjProfesor
{
    //-----------------------------------------------------------------------
    // Zona pública de la clase.
    //-----------------------------------------------------------------------
    /**
     * Constructor de la clase.
     */
    public ObjProfesor ()
    {
        this.dni = 0;
        this.universidad = 0;
        this.facultad = 0;
        this.departamento = 0;
        this.nombre = "";
        this.apellidos = "";
    }

    /**
     * Constructor de la clase.
     * @param dni          DNI del profesor.
     * @param universidad  ID de la universidad del profesor.
     * @param facultad     ID de la facultad del profesor.
     * @param departamento ID de la facultad del profesor.
     * @param nombre       Nombre del profesor.
     * @param apellidos    Apellidos del profesor.
     */
    public ObjProfesor (int dni, int universidad, int facultad,
            int departamento, String nombre, String apellidos)
    {
        this.dni = dni;
        this.universidad = universidad;
        this.facultad = facultad;
        this.departamento = departamento;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     * Constructor de la clase.
     * @param obj Objeto a copiar.
     */
    public ObjProfesor (ObjProfesor obj)
    {
        this.dni = obj.dni;
        this.universidad = obj.universidad;
        this.facultad = obj.facultad;
        this.departamento = obj.departamento;
        this.nombre = obj.nombre;
        this.apellidos = obj.apellidos;
    }

    //-----------------------------------------------------------------------
    // Gets.
    //-----------------------------------------------------------------------
    /**
     * Método para obtener el valor del campo DNI.
     * @return int Devuelve el valor del campo DNI.
     */
    public int getDNI ()
    {
        return this.dni;
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

    /**
     * Método para obtener el valor del campo apellidos.
     * @return String Devuelve el valor del campo apellidos.
     */
    public String getApellidos ()
    {
        return this.apellidos;
    }

    //-----------------------------------------------------------------------
    // Sets.
    //-----------------------------------------------------------------------
    /**
     * Método para establecer el valor del campo DNI.
     * @param value int Valor que queremos asignarle al campo.
     */
    public void setDNI (int value)
    {
        this.dni = value;
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

    /**
     * Método para establecer el valor del campo apellidos.
     * @param value String Valor que queremos asignarle al campo.
     */
    public void setApellidos (String value)
    {
        this.apellidos = value;
    }

    //-----------------------------------------------------------------------
    // Zona privada de la clase.
    //-----------------------------------------------------------------------
    private int dni;
    private int universidad;
    private int facultad;
    private int departamento;
    private String nombre;
    private String apellidos;
}
