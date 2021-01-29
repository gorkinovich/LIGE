//--------------------------------------------------------------------------------
// Practica B - LIGE
// Gorka Suárez García
//--------------------------------------------------------------------------------
package com.gorka.lige.labs;
import java.util.*;

public class Facultad
{
    //----------------------------------------------------------------------------
    // Propiedades
    //----------------------------------------------------------------------------
    private int id;
    private String nombre;
    private String direccion;
    private LinkedList<String> alumnos;
    private LinkedList<Departamento> departamentos;
    private LinkedList<String> licenciaturas;
    private LinkedList<String> cursos;
    
    
    //----------------------------------------------------------------------------
    // Constructores
    //----------------------------------------------------------------------------
    public Facultad ()
    {
        this.id            = 0;
        this.nombre        = "";
        this.direccion     = "";
        this.alumnos       = new LinkedList<String>();
        this.departamentos = new LinkedList<Departamento>();
        this.licenciaturas = new LinkedList<String>();
        this.cursos        = new LinkedList<String>();
    }
    
    public Facultad (int id, String nombre, String direccion, LinkedList<String> alumnos,
                     LinkedList<Departamento> departamentos, LinkedList<String> licenciaturas,
                     LinkedList<String> cursos)
    {
        this.id            = id;
        this.nombre        = nombre;
        this.direccion     = direccion;
        this.alumnos       = alumnos;
        this.departamentos = departamentos;
        this.licenciaturas = licenciaturas;
        this.cursos        = cursos;
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
    
    public String getDireccion ()
    {
        return this.direccion;
    }
    
    public LinkedList<String> getAlumnos ()
    {
        return this.alumnos;
    }
    
    public LinkedList<Departamento> getDepartamentos ()
    {
        return this.departamentos;
    }
    
    public LinkedList<String> getLicenciaturas ()
    {
        return this.licenciaturas;
    }
    
    public LinkedList<String> getCursos ()
    {
        return this.cursos;
    }
    
    
    public void setID (int id)
    {
        this.id = id;
    }
    
    
    public void mostrarDepartamentos ()
    {
        System.out.println("+ Lista de departamentos de la facultad:");
            
        for(Departamento departamento : this.departamentos)
        {
            System.out.println("\tID:     " + Integer.toString(departamento.getID()));
            System.out.println("\tNombre: " + departamento.getNombre());
            System.out.println();
            departamento.mostrarProfesores("\t");  System.out.println();
            departamento.mostrarAsignaturas("\t"); System.out.println("\n");
        }
    }
    
    public void mostrarLicenciaturasYCursos ()
    {
        System.out.println("+ Lista de licenciaturas de la facultad:");
            
        for(String licenciatura : this.licenciaturas)
        {
            System.out.println("\t" + licenciatura);
        }
        
        System.out.println();
        System.out.println("+ Lista de cursos de la facultad:");
        
        for(String curso : this.cursos)
        {
            System.out.println("\t" + curso);
        }
    }
    
    
    public void mostrarDepartamentos (String separacion)
    {
        System.out.println(separacion + "+ Lista de departamentos de la facultad:");
            
        for(Departamento departamento : this.departamentos)
        {
            System.out.println(separacion + "\tID:     " + Integer.toString(departamento.getID()));
            System.out.println(separacion + "\tNombre: " + departamento.getNombre());
            System.out.println();
            departamento.mostrarProfesores(separacion + "\t");  System.out.println();
            departamento.mostrarAsignaturas(separacion + "\t"); System.out.println("\n");
        }
    }
    
    public void mostrarLicenciaturasYCursos (String separacion)
    {
        System.out.println(separacion + "+ Lista de licenciaturas de la facultad:");
            
        for(String licenciatura : this.licenciaturas)
        {
            System.out.println(separacion + "\t" + licenciatura);
        }
        
        System.out.println();
        System.out.println(separacion + "+ Lista de cursos de la facultad:");
        
        for(String curso : this.cursos)
        {
            System.out.println(separacion + "\t" + curso);
        }
    }
}