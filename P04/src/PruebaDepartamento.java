//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Departamento;
import com.sgu.objs.ObjDepartamento;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaDepartamento</p>
 * <p>Description: Cliente para probar la gestión de departamentos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaDepartamento
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaDepartamento ()
    {
        tracer = new Tracer();
        gestor = new Departamento();
        tracer.debug("PruebaDepartamento", "PruebaDepartamento()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int id, int universidad, int facultad, String nombre)
    {
        tracer.debug("PruebaDepartamento", "insertar()", "==================================================");
        tracer.debug("PruebaDepartamento", "insertar()", "Prueba: Insertar un elemento.");

        ObjDepartamento obj = new ObjDepartamento(id, universidad, facultad, nombre);
        gestor.insertar(obj);

        tracer.debug("PruebaDepartamento", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaDepartamento", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int id, int universidad, int facultad, String nombre)
    {
        tracer.debug("PruebaDepartamento", "modificar()", "==================================================");
        tracer.debug("PruebaDepartamento", "modificar()", "Prueba: Modificar un elemento.");

        ObjDepartamento obj = new ObjDepartamento(id, universidad, facultad, nombre);
        gestor.modificar(obj);

        tracer.debug("PruebaDepartamento", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaDepartamento", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaDepartamento", "eliminar()", "==================================================");
        tracer.debug("PruebaDepartamento", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(id, universidad, facultad);

        tracer.debug("PruebaDepartamento", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaDepartamento", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaDepartamento", "existe()", "==================================================");
        tracer.debug("PruebaDepartamento", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(id, universidad, facultad))
            tracer.debug("PruebaDepartamento", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " existe.");
        else
            tracer.debug("PruebaDepartamento", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " no existe.");

        tracer.debug("PruebaDepartamento", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaDepartamento", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaDepartamento", "listar()", "==================================================");
        tracer.debug("PruebaDepartamento", "listar()", "Prueba: Listar un elemento.");

        ObjDepartamento obj = gestor.buscar(id, universidad, facultad);
        tracer.debug("PruebaDepartamento", "listar()", "ID:          " + obj.getID());
        tracer.debug("PruebaDepartamento", "listar()", "UNIVERSIDAD: " + obj.getUniversidad());
        tracer.debug("PruebaDepartamento", "listar()", "FACULTAD:    " + obj.getFacultad());
        tracer.debug("PruebaDepartamento", "listar()", "NOMBRE:      " + obj.getNombre());

        tracer.debug("PruebaDepartamento", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaDepartamento", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaDepartamento prueba = new PruebaDepartamento();
        prueba.getTracer().debug("PruebaDepartamento", "main()", "Inicio del cliente de prueba.");

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
    private Departamento gestor;
}
