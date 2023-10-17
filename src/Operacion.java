import java.util.Date;

/**
 * Clase que representa una Operacion.
 */
public class Operacion {
    
    /**
     * Fecha de comienzo de la operación.
     */
    private Date fechaComienzoOperacion;
    
    /**
     * Identificador del buque.
     */
    private char idBuque;
    
    /**
     * Indica si se debe cargar el producto.
     */
    private boolean cargar;
    
    /**
     * Cantidad de días necesarios para la carga.
     */
    private int diasCarga;
    
    /**
     * Indica si se debe trasladar el producto.
     */
    private boolean trasladar;
    
    /**
     * Cantidad de días necesarios para el traslado.
     */
    private int diasTraslado;
    
    /**
     * Indica si se debe descargar el producto.
     */
    private boolean descargar;
    
    /**
     * Cantidad de días necesarios para la descarga.
     */
    private int diasDescarga;
    
    /**
     * Puerto de origen de la operación.
     */
    private Puerto origen;
    
    /**
     * Puerto de destino de la operación.
     */
    private Puerto destino;
    
    /**
     * Producto cargado en la operación.
     */
    private Producto productoCargado;

    /**
     * Constructor de la clase Operacion.
     *
     * @param fechaComienzoOperacion Fecha de comienzo de la operación.
     * @param idBuque                Identificador del buque.
     * @param cargar                 Indica si se debe cargar el producto.
     * @param diasCarga              Cantidad de días necesarios para la carga.
     * @param trasladar              Indica si se debe trasladar el producto.
     * @param diasTraslado           Cantidad de días necesarios para el traslado.
     * @param descargar              Indica si se debe descargar el producto.
     * @param diasDescarga           Cantidad de días necesarios para la descarga.
     * @param origen                 Puerto de origen de la operación.
     * @param destino                Puerto de destino de la operación.
     * @param productoCargado        Producto cargado en la operación.
     */
    public Operacion(Date fechaComienzoOperacion, char idBuque, boolean cargar, int diasCarga, boolean trasladar, int diasTraslado, boolean descargar, int diasDescarga, Puerto origen, Puerto destino, Producto productoCargado) {
        this.fechaComienzoOperacion = fechaComienzoOperacion;
        this.idBuque = idBuque;
        this.cargar = cargar;
        this.diasCarga = diasCarga;
        this.trasladar = trasladar;
        this.diasTraslado = diasTraslado;
        this.descargar = descargar;
        this.diasDescarga = diasDescarga;
        this.origen = origen;
        this.destino = destino;
        this.productoCargado = productoCargado;
    }

    /**
     * Getter para obtener la fecha de comienzo de la operación.
     *
     * @return Fecha de comienzo de la operación.
     */
    public Date getFechaComienzoOperacion() {
        return fechaComienzoOperacion;
    }

    /**
     * Setter para establecer la fecha de comienzo de la operación.
     *
     * @param fechaComienzoOperacion Fecha de comienzo de la operación.
     */
    public void setFechaComienzoOperacion(Date fechaComienzoOperacion) {
        this.fechaComienzoOperacion = fechaComienzoOperacion;
    }

    /**
     * Getter para obtener el identificador del buque.
     *
     * @return Identificador del buque.
     */
    public char getIdBuque() {
        return idBuque;
    }

    /**
     * Setter para establecer el identificador del buque.
     *
     * @param idBuque Identificador del buque.
     */
    public void setIdBuque(char idBuque) {
        this.idBuque = idBuque;
    }

    /**
     * Getter para obtener si se debe cargar el producto.
     *
     * @return Si se debe cargar el producto.
     */
    public boolean isCargar() {
        return cargar;
    }

    /**
     * Setter para establecer si se debe cargar el producto.
     *
     * @param cargar Si se debe cargar el producto.
     */
    public void setCargar(boolean cargar) {
        this.cargar = cargar;
    }

    /**
     * Getter para obtener la cantidad de días necesarios para la carga.
     *
     * @return Cantidad de días necesarios para la carga.
     */
    public int getDiasCarga() {
        return diasCarga;
    }

    /**
     * Setter para establecer la cantidad de días necesarios para la carga.
     *
     * @param diasCarga Cantidad de días necesarios para la carga.
     */
    public void setDiasCarga(int diasCarga) {
        this.diasCarga = diasCarga;
    }

    /**
     * Getter para obtener si se debe trasladar el producto.
     *
     * @return Si se debe trasladar el producto.
     */
    public boolean isTrasladar() {
        return trasladar;
    }

    /**
     * Setter para establecer si se debe trasladar el producto.
     *
     * @param trasladar Si se debe trasladar el producto.
     */
    public void setTrasladar(boolean trasladar) {
        this.trasladar = trasladar;
    }

    /**
     * Getter para obtener la cantidad de días necesarios para el traslado.
     *
     * @return Cantidad de días necesarios para el traslado.
     */
    public int getDiasTraslado() {
        return diasTraslado;
    }

    /**
     * Setter para establecer la cantidad de días necesarios para el traslado.
     *
     * @param diasTraslado Cantidad de días necesarios para el traslado.
     */
    public void setDiasTraslado(int diasTraslado) {
        this.diasTraslado = diasTraslado;
    }

    /**
     * Getter para obtener si se debe descargar el producto.
     *
     * @return Si se debe descargar el producto.
     */
    public boolean isDescargar() {
        return descargar;
    }

    /**
     * Setter para establecer si se debe descargar el producto.
     *
     * @param descargar Si se debe descargar el producto.
     */
    public void setDescargar(boolean descargar) {
        this.descargar = descargar;
    }

    /**
     * Getter para obtener la cantidad de días necesarios para la descarga.
     *
     * @return Cantidad de días necesarios para la descarga.
     */
    public int getDiasDescarga() {
        return diasDescarga;
    }

    /**
     * Método setter para establecer la cantidad de días necesarios para la descarga.
     *
     * @param diasDescarga Cantidad de días necesarios para la descarga.
     */
    public void setDiasDescarga(int diasDescarga) {
        this.diasDescarga = diasDescarga;
    }

    /**
     * Método getter para obtener el puerto de origen.
     *
     * @return Puerto de origen.
     */
    public Puerto getOrigen() {
        return origen;
    }

    /**
     * Método setter para establecer el puerto de origen.
     *
     * @param origen Puerto de origen.
     */
    public void setOrigen(Puerto origen) {
        this.origen = origen;
    }

    /**
     * Método getter para obtener el puerto de destino.
     *
     * @return Puerto de destino.
     */
    public Puerto getDestino() {
        return destino;
    }

    /**
     * Método setter para establecer el puerto de destino.
     *
     * @param destino Puerto de destino.
     */
    public void setDestino(Puerto destino) {
        this.destino = destino;
    }

    /**
     * Método getter para obtener el producto cargado.
     *
     * @return Producto cargado.
     */
    public Producto getProductoCargado() {
        return productoCargado;
    }

    /**
     * Método setter para establecer el producto cargado.
     *
     * @param productoCargado Producto cargado.
     */
    public void setProductoCargado(Producto productoCargado) {
        this.productoCargado = productoCargado;
    }
}
