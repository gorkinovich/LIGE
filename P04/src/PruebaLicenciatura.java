//***************************************************************************
// Practica C y D - LIGE - 2º B Ing. Tec. en Informática de Gestión
// Alumno: Gorka Suárez García
//***************************************************************************
import com.sgu.gestion.Licenciatura;
import com.sgu.objs.ObjLicenciatura;
import com.sgu.util.Tracer;

/**
 * <p>Title: PruebaLicenciatura</p>
 * <p>Description: Cliente para probar la gestión de licenciaturas.</p>
 * @author Gorka Suárez García
 * @version 1.0
 */
public class PruebaLicenciatura
{
    //=======================================================================
    // Zona pública de la clase.
    //=======================================================================
    public PruebaLicenciatura ()
    {
        tracer = new Tracer();
        gestor = new Licenciatura();
        tracer.debug("PruebaLicenciatura", "PruebaLicenciatura()", "Objeto creado.");
    }

    //-----------------------------------------------------------------------
    public Tracer getTracer ()
    {
        return this.tracer;
    }

    //-----------------------------------------------------------------------
    public void insertar (int id, int universidad, int facultad, String nombre)
    {
        tracer.debug("PruebaLicenciatura", "insertar()", "==================================================");
        tracer.debug("PruebaLicenciatura", "insertar()", "Prueba: Insertar un elemento.");

        ObjLicenciatura obj = new ObjLicenciatura(id, universidad, facultad, nombre);
        gestor.insertar(obj);

        tracer.debug("PruebaLicenciatura", "insertar()", "Prueba: Fin insertar un elemento.");
        tracer.debug("PruebaLicenciatura", "insertar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void modificar (int id, int universidad, int facultad, String nombre)
    {
        tracer.debug("PruebaLicenciatura", "modificar()", "==================================================");
        tracer.debug("PruebaLicenciatura", "modificar()", "Prueba: Modificar un elemento.");

        ObjLicenciatura obj = new ObjLicenciatura(id, universidad, facultad, nombre);
        gestor.modificar(obj);

        tracer.debug("PruebaLicenciatura", "modificar()", "Prueba: Fin modificar un elemento.");
        tracer.debug("PruebaLicenciatura", "modificar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void eliminar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaLicenciatura", "eliminar()", "==================================================");
        tracer.debug("PruebaLicenciatura", "eliminar()", "Prueba: Eliminar un elemento.");

        gestor.eliminar(id, universidad, facultad);

        tracer.debug("PruebaLicenciatura", "eliminar()", "Prueba: Fin eliminar un elemento.");
        tracer.debug("PruebaLicenciatura", "eliminar()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void existe (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaLicenciatura", "existe()", "==================================================");
        tracer.debug("PruebaLicenciatura", "existe()", "Prueba: Existe un elemento.");

        if(gestor.existe(id, universidad, facultad))
            tracer.debug("PruebaLicenciatura", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " existe.");
        else
            tracer.debug("PruebaLicenciatura", "existe()", "El elemento ID=" + id +
                         ", UNIVERSIDAD=" + universidad + ", FACULTAD=" + facultad +
                         " no existe.");

        tracer.debug("PruebaLicenciatura", "existe()", "Prueba: Fin existe un elemento.");
        tracer.debug("PruebaLicenciatura", "existe()", "==================================================\n\n");
    }

    //-----------------------------------------------------------------------
    public void listar (int id, int universidad, int facultad)
    {
        tracer.debug("PruebaLicenciatura", "listar()", "==================================================");
        tracer.debug("PruebaLicenciatura", "listar()", "Prueba: Listar un elemento.");

        ObjLicenciatura obj = gestor.buscar(id, universidad, facultad);
        tracer.debug("PruebaDepartamento", "listar()", "ID:          " + obj.getID());
        tracer.debug("PruebaDepartamento", "listar()", "UNIVERSIDAD: " + obj.getUniversidad());
        tracer.debug("PruebaDepartamento", "listar()", "FACULTAD:    " + obj.getFacultad());
        tracer.debug("PruebaDepartamento", "listar()", "NOMBRE:      " + obj.getNombre());

        tracer.debug("PruebaLicenciatura", "listar()", "Prueba: Fin listar un elemento.");
        tracer.debug("PruebaLicenciatura", "listar()", "==================================================\n\n");
    }


    //-----------------------------------------------------------------------
    public static void main (String[] args)
    {
        PruebaLicenciatura prueba = new PruebaLicenciatura();
        prueba.getTracer().debug("PruebaLicenciatura", "main()", "Inicio del cliente de prueba.");

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
    private Licenciatura gestor;
}
