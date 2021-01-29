//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Facultad;
import com.sgu.objs.ObjFacultad;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaFacultad</p>
 * <p>Description: Cliente para probar la gestión de facultades.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaFacultad
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaFacultad ()
    {
        tracer = new Tracer();
        gestor = new Facultad();
        tracer.debug("PruebaFacultad", "PruebaFacultad()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int id, int universidad, String nombre, String direccion)
    {
        tracer.debug("PruebaFacultad", "insertar()", "==================================================");
        tracer.debug("PruebaFacultad", "insertar()", "Prueba: Insertar un elemento.");

        ObjFacultad obj = new ObjFacultad(id, universidad, nombre, direccion);
        gestor.insertar(obj);

        tracer.debug("PruebaFacultad", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaFacultad", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int id, int universidad, String nombre, String direccion)
    {
        tracer.debug("PruebaFacultad", "modificar()", "==================================================");
        tracer.debug("PruebaFacultad", "modificar()", "Prueba: Modificar un elemento.");

        ObjFacultad obj = new ObjFacultad(id, universidad, nombre, direccion);
        gestor.modificar(obj);

        tracer.debug("PruebaFacultad", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaFacultad", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int id, int universidad)
    {
        tracer.debug("PruebaFacultad", "eliminar()", "==================================================");
        tracer.debug("PruebaFacultad", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(id, universidad);

        tracer.debug("PruebaFacultad", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaFacultad", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int id, int universidad)
    {
        tracer.debug("PruebaFacultad", "existe()", "==================================================");
        tracer.debug("PruebaFacultad", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(id, universidad))
            tracer.debug("PruebaFacultad", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + " existe.");
        else
            tracer.debug("PruebaFacultad", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + " no existe.");

        tracer.debug("PruebaFacultad", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaFacultad", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int id, int universidad)
    {
        tracer.debug("PruebaFacultad", "listar()", "==================================================");
        tracer.debug("PruebaFacultad", "listar()", "Prueba: Listar un elemento.");

        ObjFacultad obj = gestor.buscar(id, universidad);
        tracer.debug("PruebaFacultad", "listar()", "ID:          " + obj.getID());
        tracer.debug("PruebaFacultad", "listar()", "UNIVERSIDAD: " + obj.getUniversidad());
        tracer.debug("PruebaFacultad", "listar()", "NOMBRE:      " + obj.getNombre());
        tracer.debug("PruebaFacultad", "listar()", "DIRECCION:   " + obj.getDireccion());

        tracer.debug("PruebaFacultad", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaFacultad", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaFacultad prueba = new PruebaFacultad();
        prueba.getTracer().debug("PruebaFacultad", "main()", "Inicio del cliente de prueba.");

        prueba.insertar(1, 1, "asdf", "asdf");
        prueba.existe(1, 1);
        prueba.modificar(1, 1, "qwer", "qwer");
        prueba.listar(1, 1);
        prueba.eliminar(1, 1);
        prueba.existe(1, 1);
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private Facultad gestor;
}
