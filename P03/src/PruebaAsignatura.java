//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Asignatura;
import com.sgu.objs.ObjAsignatura;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaAsignatura</p>
 * <p>Description: Cliente para probar la gestión de asignaturas.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaAsignatura
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaAsignatura ()
    {
        tracer = new Tracer();
        gestor = new Asignatura();
        tracer.debug("PruebaAsignatura", "PruebaAsignatura()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int id, int universidad, int facultad, int departamento, String nombre)
    {
        tracer.debug("PruebaAsignatura", "insertar()", "==================================================");
        tracer.debug("PruebaAsignatura", "insertar()", "Prueba: Insertar un elemento.");

        ObjAsignatura obj = new ObjAsignatura(id, universidad, facultad, departamento, nombre);
        gestor.insertar(obj);

        tracer.debug("PruebaAsignatura", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaAsignatura", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int id, int universidad, int facultad, int departamento, String nombre)
    {
        tracer.debug("PruebaAsignatura", "modificar()", "==================================================");
        tracer.debug("PruebaAsignatura", "modificar()", "Prueba: Modificar un elemento.");

        ObjAsignatura obj = new ObjAsignatura(id, universidad, facultad, departamento, nombre);
        gestor.modificar(obj);

        tracer.debug("PruebaAsignatura", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaAsignatura", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaAsignatura", "eliminar()", "==================================================");
        tracer.debug("PruebaAsignatura", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(id, universidad, facultad);

        tracer.debug("PruebaAsignatura", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaAsignatura", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaAsignatura", "existe()", "==================================================");
        tracer.debug("PruebaAsignatura", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(id, universidad, facultad))
            tracer.debug("PruebaAsignatura", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " existe.");
        else
            tracer.debug("PruebaAsignatura", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " no existe.");

        tracer.debug("PruebaAsignatura", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaAsignatura", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaAsignatura", "listar()", "==================================================");
        tracer.debug("PruebaAsignatura", "listar()", "Prueba: Listar un elemento.");

        ObjAsignatura obj = gestor.buscar(id, universidad, facultad);
        tracer.debug("PruebaAsignatura", "listar()", "ID:           " + obj.getID());
        tracer.debug("PruebaAsignatura", "listar()", "UNIVERSIDAD:  " + obj.getUniversidad());
        tracer.debug("PruebaAsignatura", "listar()", "FACULTAD:     " + obj.getFacultad());
        tracer.debug("PruebaAsignatura", "listar()", "DEPARTAMENTO: " + obj.getFacultad());
        tracer.debug("PruebaAsignatura", "listar()", "NOMBRE:       " + obj.getNombre());

        tracer.debug("PruebaAsignatura", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaAsignatura", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaAsignatura prueba = new PruebaAsignatura();
        prueba.getTracer().debug("PruebaAsignatura", "main()", "Inicio del cliente de prueba.");

        prueba.insertar(1, 1, 1, 1, "asdf");
        prueba.existe(1, 1, 1);
        prueba.modificar(1, 1, 1, 1, "qwer");
        prueba.listar(1, 1, 1);
        prueba.eliminar(1, 1, 1);
        prueba.existe(1, 1, 1);
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private Asignatura gestor;
}
