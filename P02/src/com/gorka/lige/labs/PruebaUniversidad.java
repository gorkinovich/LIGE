//--------------------------------------------------------------------------------
// Practica B - LIGE
// Gorka Suárez García
//--------------------------------------------------------------------------------
package com.gorka.lige.labs;
import java.util.*;

public class PruebaUniversidad
{
    //----------------------------------------------------------------------------
    // Propiedades
    //----------------------------------------------------------------------------
    private Departamento [] departamentos;
    private Facultad [] facultades;
    private Universidad universidad;
    
    private final int MAX_DEPS = 5;
    private final int MAX_FACS = 3;
    
    
    //----------------------------------------------------------------------------
    // Constructores
    //----------------------------------------------------------------------------
    public PruebaUniversidad ()
    {
        this.departamentos = null;
        this.facultades    = null;
        this.universidad   = null;
    }
    
    
    //----------------------------------------------------------------------------
    // Métodos auxiliares
    //----------------------------------------------------------------------------
    private void Pause ()
    {
        try
        {
            System.out.print("Pulse enter para continuar...");
            System.in.skip(System.in.available());
            System.in.read();
            System.out.println("\n\n");
        }
        catch(Exception e)
        {
        }
    }
    
    //----------------------------------------------------------------------------
    // Métodos de inicialización
    //----------------------------------------------------------------------------
    private void InitDeps ()
    {
        this.departamentos = new Departamento[MAX_DEPS];
        
        LinkedList<String> profesores;
        LinkedList<String> asignaturas;
        Departamento aux;
        
        
        //------------------------------------------------------------------------
        // Departamento de Lengua
        //------------------------------------------------------------------------
        profesores = new LinkedList<String>();
        profesores.add("Miguel de Cervantes");
        profesores.add("Miguel de Unamuno");
        profesores.add("Francisco de Quevedo");
        profesores.add("Lope de Vega");
        
        asignaturas = new LinkedList<String>();
        asignaturas.add("Literatura Clasica");
        asignaturas.add("La Generacion del 98");
        asignaturas.add("Poesia de la Edad de Oro");
        asignaturas.add("El Teatro de la Edad de Oro");
        
        aux = new Departamento(0, "Lengua", profesores, asignaturas);
        aux.setID(100);
        
        this.departamentos[0] = aux;
        
        
        //------------------------------------------------------------------------
        // Departamento de Historia
        //------------------------------------------------------------------------
        profesores = new LinkedList<String>();
        profesores.add("Socrates");
        profesores.add("Cayo Julio Cesar");
        profesores.add("Napoleon Bonaparte");
        profesores.add("Miyamoto Musashi");
        
        asignaturas = new LinkedList<String>();
        asignaturas.add("La Grecia clasica");
        asignaturas.add("La Roma Imperial");
        asignaturas.add("Tras la Revolucion Francesa");
        asignaturas.add("Los Samurais");
        
        aux = new Departamento(0, "Historia", profesores, asignaturas);
        aux.setID(200);
        
        this.departamentos[1] = aux;
        
        
        //------------------------------------------------------------------------
        // Departamento de Matematicas
        //------------------------------------------------------------------------
        profesores = new LinkedList<String>();
        profesores.add("Jean-Baptiste Joseph Fourier");
        profesores.add("Carl Friedrich Gauss");
        profesores.add("Leonhard Euler");
        profesores.add("Pitagoras");
        
        asignaturas = new LinkedList<String>();
        asignaturas.add("Calculo");
        asignaturas.add("Algebra");
        asignaturas.add("Matematica Discreta");
        asignaturas.add("Geometria");
        
        aux = new Departamento(0, "Matematicas", profesores, asignaturas);
        aux.setID(300);
        
        this.departamentos[2] = aux;
        
        
        //------------------------------------------------------------------------
        // Departamento de Fisica
        //------------------------------------------------------------------------
        profesores = new LinkedList<String>();
        profesores.add("Albert Einstein");
        profesores.add("Isaac Newton");
        profesores.add("Stephen Hawking");
        profesores.add("Edward Witten");
        
        asignaturas = new LinkedList<String>();
        asignaturas.add("Teoria de la Relatividad");
        asignaturas.add("La Cinematica y las Fuerzas");
        asignaturas.add("Los Agujeros Negros");
        asignaturas.add("La Teoria de las Supercuerdas");
        
        aux = new Departamento(0, "Fisica", profesores, asignaturas);
        aux.setID(400);
        
        this.departamentos[3] = aux;
        
        
        //------------------------------------------------------------------------
        // Departamento de Ingles
        //------------------------------------------------------------------------
        profesores = new LinkedList<String>();
        profesores.add("William Shakespeare");
        profesores.add("Jim Morrison");
        profesores.add("Terry Pratchett");
        profesores.add("John Ronald Reuel Tolkien");
        
        asignaturas = new LinkedList<String>();
        asignaturas.add("Literatura Clasica");
        asignaturas.add("Poesia Moderna");
        asignaturas.add("Literatura Moderna");
        asignaturas.add("Raices de la Lengua Inglesa y su Historia");
        
        aux = new Departamento(0, "Ingles", profesores, asignaturas);
        aux.setID(500);
        
        this.departamentos[4] = aux;
    }
    
    
    private void InitFacs ()
    {
        this.facultades = new Facultad[MAX_FACS];
        
        LinkedList<String> alumnos;
        LinkedList<Departamento> departamentos;
        LinkedList<String> licenciaturas;
        LinkedList<String> cursos;
        Facultad aux;
        
        
        //------------------------------------------------------------------------
        // Facultad de Filología
        //------------------------------------------------------------------------
        alumnos = new LinkedList<String>();
        alumnos.add("Guybrush Threepwood");
        alumnos.add("Bobbin Threadbare");
        alumnos.add("Boston Low");
        alumnos.add("Manny Calavera");
        
        departamentos = new LinkedList<Departamento>();
        departamentos.add(this.departamentos[0]);
        departamentos.add(this.departamentos[4]);
        
        licenciaturas = new LinkedList<String>();
        licenciaturas.add("Filologia Castellana");
        licenciaturas.add("Filologia Inglesa");
        
        cursos = new LinkedList<String>();
        cursos.add("Repaso al Latin");
        cursos.add("Repaso al Celta");
        
        aux = new Facultad(0, "Facultad de Filologia", "C/Hamperdine el Grande",
                           alumnos, departamentos, licenciaturas, cursos);        
        aux.setID(1000);
        
        this.facultades[0] = aux;
        
        
        //------------------------------------------------------------------------
        // Facultad de Historia
        //------------------------------------------------------------------------
        alumnos = new LinkedList<String>();
        alumnos.add("King Graham");
        alumnos.add("Larry Laffer");
        alumnos.add("Gabriel Knight");
        alumnos.add("Roger Wilco");
        
        departamentos = new LinkedList<Departamento>();
        departamentos.add(this.departamentos[1]);
        
        licenciaturas = new LinkedList<String>();
        licenciaturas.add("Historia Clasica");
        licenciaturas.add("Historia Moderna");
        
        cursos = new LinkedList<String>();
        cursos.add("Batallas Antiguas");
        cursos.add("Batallas Modernas");
        
        aux = new Facultad(0, "Facultad de Historia", "Avenida de Esparta",
                           alumnos, departamentos, licenciaturas, cursos);        
        aux.setID(2000);
        
        this.facultades[1] = aux;
        
        
        //------------------------------------------------------------------------
        // Facultad de Físicas
        //------------------------------------------------------------------------
        alumnos = new LinkedList<String>();
        alumnos.add("Gordon Freeman");
        alumnos.add("Richard B. Riddick");
        alumnos.add("Master Chief");
        alumnos.add("Duke Nukem");
        
        departamentos = new LinkedList<Departamento>();
        departamentos.add(this.departamentos[2]);
        departamentos.add(this.departamentos[3]);
        
        licenciaturas = new LinkedList<String>();
        licenciaturas.add("Matematicas");
        licenciaturas.add("Fisica");
        
        cursos = new LinkedList<String>();
        cursos.add("Fisica Cuantica");
        cursos.add("Teoria M");
        
        aux = new Facultad(0, "Facultad de Fisicas", "C/Indefinido entre Cero",
                           alumnos, departamentos, licenciaturas, cursos);        
        aux.setID(3000);
        
        this.facultades[2] = aux;
    }
    
 
    private void InitUniv ()
    {
        LinkedList<Facultad> facultades = new LinkedList<Facultad>();
        facultades.add(this.facultades[0]);
        facultades.add(this.facultades[1]);
        facultades.add(this.facultades[2]);
                
        this.universidad = new Universidad("Universidad Hamperdine",
                                           "Black Mesa", facultades);
    }
    
    
    //----------------------------------------------------------------------------
    // Métodos de pruebas
    //----------------------------------------------------------------------------
    public void TestDeps ()
    {
        this.InitDeps();
        
        System.out.println("****************************");
        System.out.println("* Listado de departamentos *");
        System.out.println("****************************\n");
        
        for(Departamento departamento : this.departamentos)
        {
            System.out.println("ID:        " + Integer.toString(departamento.getID()));
            System.out.println("Nombre:    " + departamento.getNombre());
            System.out.println();
            departamento.mostrarProfesores();  System.out.println();
            departamento.mostrarAsignaturas(); System.out.println("\n");
        }
        
        this.Pause();
    }
    
    
    public void TestFacs ()
    {
        this.InitFacs();
        
        System.out.println("*************************");
        System.out.println("* Listado de facultades *");
        System.out.println("*************************\n");
        
        for(Facultad facultad : this.facultades)
        {
            System.out.println("ID:        " + Integer.toString(facultad.getID()));
            System.out.println("Nombre:    " + facultad.getNombre());
            System.out.println("Direccion: " + facultad.getDireccion());
            
            System.out.println("\n+ Lista de alumnos:");
            for(String alumno : facultad.getAlumnos())
            {
                System.out.println("\t" + alumno);
            }
            
            System.out.println();
            facultad.mostrarDepartamentos();
            facultad.mostrarLicenciaturasYCursos();
            System.out.println("\n\n");
        }
        
        this.Pause();
    }
    
    
    public void TestUniv ()
    {
        this.InitUniv();
        
        System.out.println("******************************************");
        System.out.println("* Listado de los datos de la universidad *");
        System.out.println("******************************************\n");
        
        System.out.println("Nombre:    " + this.universidad.getNombre());
        System.out.println("Direccion: " + this.universidad.getDireccion());
        
        System.out.println();
        this.universidad.mostrarFacultades();
        this.Pause();
    }
    
    
    //----------------------------------------------------------------------------
    // Main
    //----------------------------------------------------------------------------
    public static void main (String args[])
    {
        try
        {
            PruebaUniversidad prueba = new PruebaUniversidad();
            
            prueba.TestDeps();
            prueba.TestFacs();
            prueba.TestUniv();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}