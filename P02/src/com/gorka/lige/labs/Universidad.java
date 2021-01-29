//--------------------------------------------------------------------------------
// Practica B - LIGE
// Gorka Suárez García
//--------------------------------------------------------------------------------
package com.gorka.lige.labs;
import java.util.*;

public class Universidad
{
    //----------------------------------------------------------------------------
    // Propiedades
    //----------------------------------------------------------------------------
    private String nombre;
    private String direccion;
    private LinkedList<Facultad> facultades;
    
    
    //----------------------------------------------------------------------------
    // Constructores
    //----------------------------------------------------------------------------
    public Universidad ()
    {
        this.nombre     = "";
        this.direccion  = "";
        this.facultades = new LinkedList<Facultad>();
    }
    
    public Universidad (String nombre, String direccion, LinkedList<Facultad> facultades)
    {
        this.nombre     = nombre;
        this.direccion  = direccion;
        this.facultades = facultades;
    }
    
    
    //----------------------------------------------------------------------------
    // Métodos
    //----------------------------------------------------------------------------
    public String getNombre ()
    {
        return this.nombre;
    }
    
    public String getDireccion ()
    {
        return this.direccion;
    }
    
    public LinkedList<Facultad> getFacultades ()
    {
        return this.facultades;
    }
    
    public void mostrarFacultades ()
    {
        System.out.println("+ Lista de facultades de la universidad:");
        
        for(Facultad facultad : this.facultades)
        {
            System.out.println("\tID:        " + Integer.toString(facultad.getID()));
            System.out.println("\tNombre:    " + facultad.getNombre());
            System.out.println("\tDireccion: " + facultad.getDireccion());
            
            System.out.println("\n\t+ Lista de alumnos:");
            for(String alumno : facultad.getAlumnos())
            {
                System.out.println("\t\t" + alumno);
            }
            
            System.out.println();
            facultad.mostrarDepartamentos("\t");
            facultad.mostrarLicenciaturasYCursos("\t");
            System.out.println("\n\n");
        }
    }
}