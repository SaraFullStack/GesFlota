/**
 * Clase abstracta que representa un Producto.
 */
public abstract class Producto {
    
    /**
     * Identificador único del producto.
     */
    private int id;
    
    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Constructor de la clase Producto.
     *
     * @param id     Identificador único del producto.
     * @param nombre Nombre del producto.
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el identificador del producto.
     *
     * @return Identificador del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Método setter para establecer el identificador del producto.
     *
     * @param id Identificador del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del producto.
     *
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
