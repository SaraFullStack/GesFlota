import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa Calendario.
 */
public class Calendario {
	/**
     *  Mes del calendario
     */
	private int mes;
    /**
     * Año del calendario
     */
    private int año;
    /**
     * Lista de operaciones planificadas para el mes y año del calendario
     */
    private List<Operacion> operaciones;

    /**
     * Constructor de la clase Calendario.
     *
     * @param mes  Mes del calendario.
     * @param año  Año del calendario.
     */
    public Calendario(int mes, int año) {
        this.mes = mes;
        this.año = año;
        operaciones = new ArrayList<>();
    }

    /**
     * Método getter para obtener el mes del calendario.
     *
     * @return Mes del calendario.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Método setter para establecer el mes del calendario.
     *
     * @param mes Mes del calendario.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Método getter para obtener el año del calendario.
     *
     * @return Año del calendario.
     */
    public int getAño() {
        return año;
    }

    /**
     * Método setter para establecer el año del calendario.
     *
     * @param año Año del calendario.
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Método getter para obtener la lista de operaciones del calendario.
     *
     * @return Lista de operaciones planificadas para el mes y año del calendario.
     */
    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    /**
     * Método setter para establecer la lista de operaciones del calendario.
     *
     * @param operaciones Lista de operaciones planificadas para el mes y año del calendario.
     */
    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    /**
     * Método para agregar una nueva operación al calendario.
     *
     * @param operacion Operación a agregar al calendario.
     */
    public void agregarOperacion(Operacion operacion) {
        operaciones.add(operacion);
    }
}
