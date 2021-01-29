//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Universidad;
import com.sgu.objs.ObjUniversidad;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaUniversidad</p>
 * <p>Description: Cliente para probar la gestión de universidades.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaUniversidad
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaUniversidad ()
    {
        tracer = new Tracer();
        gestor = new Universidad();
        tracer.debug("PruebaUniversidad", "PruebaUniversidad()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int id, String nombre, String direccion)
    {
        tracer.debug("PruebaUniversidad", "insertar()", "==================================================");
        tracer.debug("PruebaUniversidad", "insertar()", "Prueba: Insertar un elemento.");

        ObjUniversidad obj = new ObjUniversidad(id, nombre, direccion);
        gestor.insertar(obj);

        tracer.debug("PruebaUniversidad", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaUniversidad", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int id, String nombre, String direccion)
    {
        tracer.debug("PruebaUniversidad", "modificar()", "==================================================");
        tracer.debug("PruebaUniversidad", "modificar()", "Prueba: Modificar un elemento.");

        ObjUniversidad obj = new ObjUniversidad(id, nombre, direccion);
        gestor.modificar(obj);

        tracer.debug("PruebaUniversidad", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaUniversidad", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int id)
    {
        tracer.debug("PruebaUniversidad", "eliminar()", "==================================================");
        tracer.debug("PruebaUniversidad", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(id);

        tracer.debug("PruebaUniversidad", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaUniversidad", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int id)
    {
        tracer.debug("PruebaUniversidad", "existe()", "==================================================");
        tracer.debug("PruebaUniversidad", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(id))
            tracer.debug("PruebaUniversidad", "existe()", "El elemento ID=" + id + " existe.");
        else
            tracer.debug("PruebaUniversidad", "existe()", "El elemento ID=" + id + " no existe.");

        tracer.debug("PruebaUniversidad", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaUniversidad", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int id)
    {
        tracer.debug("PruebaUniversidad", "listar()", "==================================================");
        tracer.debug("PruebaUniversidad", "listar()", "Prueba: Listar un elemento.");

        ObjUniversidad obj = gestor.buscar(id);
        tracer.debug("PruebaUniversidad", "listar()", "ID:        " + obj.getID());
        tracer.debug("PruebaUniversidad", "listar()", "NOMBRE:    " + obj.getNombre());
        tracer.debug("PruebaUniversidad", "listar()", "DIRECCION: " + obj.getDireccion());

        tracer.debug("PruebaUniversidad", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaUniversidad", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaUniversidad prueba = new PruebaUniversidad();
        prueba.getTracer().debug("PruebaUniversidad", "main()", "Inicio del cliente de prueba.");

        prueba.insertar(1, "asdf", "asdf");
        prueba.existe(1);
        prueba.modificar(1, "qwer", "qwer");
        prueba.listar(1);
        prueba.eliminar(1);
        prueba.existe(1);
    }

    //=======================================================================
    // Zona privada de la clase.
    //=======================================================================
    private Tracer tracer;
    private Universidad gestor;
}
