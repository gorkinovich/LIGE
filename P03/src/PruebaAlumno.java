//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Alumno;
import com.sgu.objs.ObjAlumno;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaAlumno</p>
 * <p>Description: Cliente para probar la gestión de alumnos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaAlumno
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaAlumno ()
    {
        tracer = new Tracer();
        gestor = new Alumno();
        tracer.debug("PruebaAlumno", "PruebaAlumno()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int dni, int universidad, int facultad, String nombre, String apellidos)
    {
        tracer.debug("PruebaAlumno", "insertar()", "==================================================");
        tracer.debug("PruebaAlumno", "insertar()", "Prueba: Insertar un elemento.");

        ObjAlumno obj = new ObjAlumno(dni, universidad, facultad, nombre, apellidos);
        gestor.insertar(obj);

        tracer.debug("PruebaAlumno", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaAlumno", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int dni, int universidad, int facultad, String nombre, String apellidos)
    {
        tracer.debug("PruebaAlumno", "modificar()", "==================================================");
        tracer.debug("PruebaAlumno", "modificar()", "Prueba: Modificar un elemento.");

        ObjAlumno obj = new ObjAlumno(dni, universidad, facultad, nombre, apellidos);
        gestor.modificar(obj);

        tracer.debug("PruebaAlumno", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaAlumno", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int dni, int universidad, int facultad)
    {
        tracer.debug("PruebaAlumno", "eliminar()", "==================================================");
        tracer.debug("PruebaAlumno", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(dni, universidad, facultad);

        tracer.debug("PruebaAlumno", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaAlumno", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int dni, int universidad, int facultad)
    {
        tracer.debug("PruebaAlumno", "existe()", "==================================================");
        tracer.debug("PruebaAlumno", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(dni, universidad, facultad))
            tracer.debug("PruebaAlumno", "existe()", "El elemento DNI=" + dni +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " existe.");
        else
            tracer.debug("PruebaAlumno", "existe()", "El elemento DNI=" + dni +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " no existe.");

        tracer.debug("PruebaAlumno", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaAlumno", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int dni, int universidad, int facultad)
    {
        tracer.debug("PruebaAlumno", "listar()", "==================================================");
        tracer.debug("PruebaAlumno", "listar()", "Prueba: Listar un elemento.");

        ObjAlumno obj = gestor.buscar(dni, universidad, facultad);
        tracer.debug("PruebaAlumno", "listar()", "DNI:         " + obj.getDNI());
        tracer.debug("PruebaAlumno", "listar()", "UNIVERSIDAD: " + obj.getUniversidad());
        tracer.debug("PruebaAlumno", "listar()", "FACULTAD:    " + obj.getFacultad());
        tracer.debug("PruebaAlumno", "listar()", "NOMBRE:      " + obj.getNombre());
        tracer.debug("PruebaAlumno", "listar()", "APELLIDOS:   " + obj.getApellidos());

        tracer.debug("PruebaAlumno", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaAlumno", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaAlumno prueba = new PruebaAlumno();
        prueba.getTracer().debug("PruebaAlumno", "main()", "Inicio del cliente de prueba.");

        prueba.insertar(1, 1, 1, "asdf", "asdf");
        prueba.existe(1, 1, 1);
        prueba.modificar(1, 1, 1, "qwer", "qwer");
        prueba.listar(1, 1, 1);
        prueba.eliminar(1, 1, 1);
        prueba.existe(1, 1, 1);
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private Alumno gestor;
}
