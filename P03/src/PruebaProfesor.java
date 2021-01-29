//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Profesor;
import com.sgu.objs.ObjProfesor;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaProfesor</p>
 * <p>Description: Cliente para probar la gestión de profesores.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaProfesor
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaProfesor ()
    {
        tracer = new Tracer();
        gestor = new Profesor();
        tracer.debug("PruebaProfesor", "PruebaProfesor()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int dni, int universidad, int facultad, int departamento,
                          String nombre, String apellidos)
    {
        tracer.debug("PruebaProfesor", "insertar()", "==================================================");
        tracer.debug("PruebaProfesor", "insertar()", "Prueba: Insertar un elemento.");

        ObjProfesor obj = new ObjProfesor(dni, universidad, facultad, departamento, nombre, apellidos);
        gestor.insertar(obj);

        tracer.debug("PruebaProfesor", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaProfesor", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int dni, int universidad, int facultad, int departamento,
                           String nombre, String apellidos)
    {
        tracer.debug("PruebaProfesor", "modificar()", "==================================================");
        tracer.debug("PruebaProfesor", "modificar()", "Prueba: Modificar un elemento.");

        ObjProfesor obj = new ObjProfesor(dni, universidad, facultad, departamento, nombre, apellidos);
        gestor.modificar(obj);

        tracer.debug("PruebaProfesor", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaProfesor", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int dni, int universidad, int facultad, int departamento)
    {
        tracer.debug("PruebaProfesor", "eliminar()", "==================================================");
        tracer.debug("PruebaProfesor", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(dni, universidad, facultad, departamento);

        tracer.debug("PruebaProfesor", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaProfesor", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int dni, int universidad, int facultad, int departamento)
    {
        tracer.debug("PruebaProfesor", "existe()", "==================================================");
        tracer.debug("PruebaProfesor", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(dni, universidad, facultad, departamento))
            tracer.debug("PruebaProfesor", "existe()", "El elemento DNI=" + dni +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         ", DEPARTAMENTO=" + departamento + " existe.");
        else
            tracer.debug("PruebaProfesor", "existe()", "El elemento DNI=" + dni +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         ", DEPARTAMENTO=" + departamento + " no existe.");

        tracer.debug("PruebaProfesor", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaProfesor", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int dni, int universidad, int facultad, int departamento)
    {
        tracer.debug("PruebaProfesor", "listar()", "==================================================");
        tracer.debug("PruebaProfesor", "listar()", "Prueba: Listar un elemento.");

        ObjProfesor obj = gestor.buscar(dni, universidad, facultad, departamento);
        tracer.debug("PruebaProfesor", "listar()", "DNI:          " + obj.getDNI());
        tracer.debug("PruebaProfesor", "listar()", "UNIVERSIDAD:  " + obj.getUniversidad());
        tracer.debug("PruebaProfesor", "listar()", "FACULTAD:     " + obj.getFacultad());
        tracer.debug("PruebaProfesor", "listar()", "DEPARTAMENTO: " + obj.getDepartamento());
        tracer.debug("PruebaProfesor", "listar()", "NOMBRE:       " + obj.getNombre());
        tracer.debug("PruebaProfesor", "listar()", "APELLIDOS:    " + obj.getApellidos());

        tracer.debug("PruebaProfesor", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaProfesor", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaProfesor prueba = new PruebaProfesor();
        prueba.getTracer().debug("PruebaProfesor", "main()", "Inicio del cliente de prueba.");

        prueba.insertar(1, 1, 1, 1, "asdf", "asdf");
        prueba.existe(1, 1, 1, 1);
        prueba.modificar(1, 1, 1, 1, "qwer", "qwer");
        prueba.listar(1, 1, 1, 1);
        prueba.eliminar(1, 1, 1, 1);
        prueba.existe(1, 1, 1, 1);
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private Profesor gestor;
}
