import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un Puerto.
 */
public abstract class Puerto {
    
    /**
     * Identificador único del puerto.
     */
    private int id;
    
    /**
     * Nombre del puerto.
     */
    private String nombre;
    
    /**
     * Lista de productos asociados al puerto.
     */
    private List<Producto> productos;

    /**
     * Constructor de la clase Puerto.
     *
     * @param id     Identificador único del puerto.
     * @param nombre Nombre del puerto.
     */
    public Puerto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        productos = new ArrayList<>();
    }

    /**
     * Método getter para obtener el identificador del puerto.
     *
     * @return Identificador del puerto.
     */
    public int getId() {
        return id;
    }

    /**
     * Método setter para establecer el identificador del puerto.
     *
     * @param id Identificador del puerto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el nombre del puerto.
     *
     * @return Nombre del puerto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del puerto.
     *
     * @param nombre Nombre del puerto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener la lista de productos del puerto.
     *
     * @return Lista de productos del puerto.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Método setter para establecer la lista de productos del puerto.
     *
     * @param productos Lista de productos del puerto.
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Método getter para obtener el alias del puerto.
     *
     * @return Alias del puerto.
     */
    public String getAlias() {
        return nombre;
    }
}
