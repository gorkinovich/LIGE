//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Curso;
import com.sgu.objs.ObjCurso;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaCurso</p>
 * <p>Description: Cliente para probar la gestión de cursos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaCurso
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaCurso ()
    {
        tracer = new Tracer();
        gestor = new Curso();
        tracer.debug("PruebaCurso", "PruebaCurso()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int id, int universidad, int facultad, String nombre)
    {
        tracer.debug("PruebaCurso", "insertar()", "==================================================");
        tracer.debug("PruebaCurso", "insertar()", "Prueba: Insertar un elemento.");

        ObjCurso obj = new ObjCurso(id, universidad, facultad, nombre);
        gestor.insertar(obj);

        tracer.debug("PruebaCurso", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaCurso", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int id, int universidad, int facultad, String nombre)
    {
        tracer.debug("PruebaCurso", "modificar()", "==================================================");
        tracer.debug("PruebaCurso", "modificar()", "Prueba: Modificar un elemento.");

        ObjCurso obj = new ObjCurso(id, universidad, facultad, nombre);
        gestor.modificar(obj);

        tracer.debug("PruebaCurso", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaCurso", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaCurso", "eliminar()", "==================================================");
        tracer.debug("PruebaCurso", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(id, universidad, facultad);

        tracer.debug("PruebaCurso", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaCurso", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaCurso", "existe()", "==================================================");
        tracer.debug("PruebaCurso", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(id, universidad, facultad))
            tracer.debug("PruebaCurso", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " existe.");
        else
            tracer.debug("PruebaCurso", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " no existe.");

        tracer.debug("PruebaCurso", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaCurso", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaCurso", "listar()", "==================================================");
        tracer.debug("PruebaCurso", "listar()", "Prueba: Listar un elemento.");

        ObjCurso obj = gestor.buscar(id, universidad, facultad);
        tracer.debug("PruebaDepartamento", "listar()", "ID:          " + obj.getID());
        tracer.debug("PruebaDepartamento", "listar()", "UNIVERSIDAD: " + obj.getUniversidad());
        tracer.debug("PruebaDepartamento", "listar()", "FACULTAD:    " + obj.getFacultad());
        tracer.debug("PruebaDepartamento", "listar()", "NOMBRE:      " + obj.getNombre());

        tracer.debug("PruebaCurso", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaCurso", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaCurso prueba = new PruebaCurso();
        prueba.getTracer().debug("PruebaCurso", "main()", "Inicio del cliente de prueba.");

        prueba.insertar(1, 1, 1, "asdf");
        prueba.existe(1, 1, 1);
        prueba.modificar(1, 1, 1, "qwer");
        prueba.listar(1, 1, 1);
        prueba.eliminar(1, 1, 1);
        prueba.existe(1, 1, 1);
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private Curso gestor;
}
