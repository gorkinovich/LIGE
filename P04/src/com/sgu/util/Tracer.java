//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
package com.sgu.util;
import java.lang.*;

/**
 * <p>Title: com.sgu.util.Tracer</p>
 * <p>Description: Traceador de SGU</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class Tracer
{
    //-----------------------------------------------------------------------
    // Zona pública de la clase.
    //-----------------------------------------------------------------------
    /**
     * Constructor de la clase.
     */
    public Tracer ()
    {
        nivel = 2;
    }

    /**
     * Método para mandar un mensaje a la consola para depurar.
     * @param clase  Clase que invoca el método.
     * @param metodo Metodo de esa clase que invoca el método.
     * @param msg    Mensaje de depuración para mostrar.
     */
    public void debug (String clase, String metodo, String msg)
    {
        if(nivel == 2)
            System.out.println(clase + ": " + metodo + ": " + msg);
        else if(nivel == 1)
            System.out.println(msg);
    }

    /**
     * Método para mandar un mensaje a la consola en caso de error.
     * @param clase  Clase que invoca el método.
     * @param metodo Metodo de esa clase que invoca el método.
     * @param msg    Mensaje de error para mostrar.
     */
    public void error (String clase, String metodo, String msg)
    {
        if(nivel == 2)
            System.out.println("ERROR: " + clase + ": " + metodo + ": " + msg);
        else
            System.out.println(msg);
    }

    //-----------------------------------------------------------------------
    // Zona privada de la clase.
    //-----------------------------------------------------------------------
    private final int nivel;
}
