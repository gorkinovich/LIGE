//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Administrativo;
import com.sgu.objs.ObjAdministrativo;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaAdministrativo</p>
 * <p>Description: Cliente para probar la gestión de administrativos.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaAdministrativo
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaAdministrativo ()
    {
        tracer = new Tracer();
        gestor = new Administrativo();
        tracer.debug("PruebaAdministrativo", "PruebaAdministrativo()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int dni, int universidad, int facultad, String nombre, String apellidos)
    {
        tracer.debug("PruebaAdministrativo", "insertar()", "==================================================");
        tracer.debug("PruebaAdministrativo", "insertar()", "Prueba: Insertar un elemento.");

        ObjAdministrativo obj = new ObjAdministrativo(dni, universidad, facultad, nombre, apellidos);
        gestor.insertar(obj);

        tracer.debug("PruebaAdministrativo", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaAdministrativo", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int dni, int universidad, int facultad, String nombre, String apellidos)
    {
        tracer.debug("PruebaAdministrativo", "modificar()", "==================================================");
        tracer.debug("PruebaAdministrativo", "modificar()", "Prueba: Modificar un elemento.");

        ObjAdministrativo obj = new ObjAdministrativo(dni, universidad, facultad, nombre, apellidos);
        gestor.modificar(obj);

        tracer.debug("PruebaAdministrativo", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaAdministrativo", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int dni, int universidad, int facultad)
    {
        tracer.debug("PruebaAdministrativo", "eliminar()", "==================================================");
        tracer.debug("PruebaAdministrativo", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(dni, universidad, facultad);

        tracer.debug("PruebaAdministrativo", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaAdministrativo", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int dni, int universidad, int facultad)
    {
        tracer.debug("PruebaAdministrativo", "existe()", "==================================================");
        tracer.debug("PruebaAdministrativo", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(dni, universidad, facultad))
            tracer.debug("PruebaAdministrativo", "existe()", "El elemento DNI=" + dni +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " existe.");
        else
            tracer.debug("PruebaAdministrativo", "existe()", "El elemento DNI=" + dni +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " no existe.");

        tracer.debug("PruebaAdministrativo", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaAdministrativo", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int dni, int universidad, int facultad)
    {
        tracer.debug("PruebaAdministrativo", "listar()", "==================================================");
        tracer.debug("PruebaAdministrativo", "listar()", "Prueba: Listar un elemento.");

        ObjAdministrativo obj = gestor.buscar(dni, universidad, facultad);
        tracer.debug("PruebaAdministrativo", "listar()", "DNI:         " + obj.getDNI());
        tracer.debug("PruebaAdministrativo", "listar()", "UNIVERSIDAD: " + obj.getUniversidad());
        tracer.debug("PruebaAdministrativo", "listar()", "FACULTAD:    " + obj.getFacultad());
        tracer.debug("PruebaAdministrativo", "listar()", "NOMBRE:      " + obj.getNombre());
        tracer.debug("PruebaAdministrativo", "listar()", "APELLIDOS:   " + obj.getApellidos());

        tracer.debug("PruebaAdministrativo", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaAdministrativo", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaAdministrativo prueba = new PruebaAdministrativo();
        prueba.getTracer().debug("PruebaAdministrativo", "main()", "Inicio del cliente de prueba.");

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
    private Administrativo gestor;
}
