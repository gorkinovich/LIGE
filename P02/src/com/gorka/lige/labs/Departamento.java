//--------------------------------------------------------------------------------
// Practica B - LIGE
// Gorka Suárez García
//--------------------------------------------------------------------------------
package com.gorka.lige.labs;
import java.util.*;

public class Departamento
{
    //----------------------------------------------------------------------------
    // Propiedades
    //----------------------------------------------------------------------------
    private int id;
    private String nombre;
    private LinkedList<String> profesores;
    private LinkedList<String> asignaturas;
    
    
    //----------------------------------------------------------------------------
    // Constructores
    //----------------------------------------------------------------------------
    public Departamento ()
    {
        this.id          = 0;
        this.nombre      = "";
        this.profesores  = new LinkedList<String>();
        this.asignaturas = new LinkedList<String>();
    }
    
    public Departamento (int id, String nombre, LinkedList<String> profesores,
                         LinkedList<String> asignaturas)
    {
        this.id          = id;
        this.nombre      = nombre;
        this.profesores  = profesores;
        this.asignaturas = asignaturas;
    }
    
    
    //----------------------------------------------------------------------------
    // Métodos
    //----------------------------------------------------------------------------
    public int getID ()
    {
        return this.id;
    }
    
    public String getNombre ()
    {
        return this.nombre;
    }
    
    public LinkedList<String> getProfesores ()
    {
        return this.profesores;
    }
    
    public LinkedList<String> getAsignaturas ()
    {
        return this.asignaturas;
    }
    
    
    public void setID (int id)
    {
        this.id = id;
    }
    
    
    public void mostrarProfesores ()
    {
        System.out.println("+ Lista de profesores del departamento:");
            
        for(String profesor : this.profesores)
        {
            System.out.println("\t" + profesor);
        }
    }
    
    public void mostrarAsignaturas ()
    {
        System.out.println("+ Lista de asignaturas del departamento:");
            
        for(String asignatura : this.asignaturas)
        {
            System.out.println("\t" + asignatura);
        }
    }
    
    
    public void mostrarProfesores (String separacion)
    {
        System.out.println(separacion + "+ Lista de profesores del departamento:");
            
        for(String profesor : this.profesores)
        {
            System.out.println(separacion + "\t" + profesor);
        }
    }
    
    public void mostrarAsignaturas (String separacion)
    {
        System.out.println(separacion + "+ Lista de asignaturas del departamento:");
            
        for(String asignatura : this.asignaturas)
        {
            System.out.println(separacion + "\t" + asignatura);
        }
    }
}