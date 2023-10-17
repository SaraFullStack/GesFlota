import java.util.Date;

/**
 * Clase que representa un Buque.
 */
public class Buque {
	/**
	 * Identificador único del buque.
	 */
	private char id;
	/**
	 * Nombre del buque.
	 */
	private String nombre;
	/**
	 * Ubicacion inicial del buque.
	 */
	private Puerto ubicacionInicial;
	/**
	 * Fecha de incorporación del buque.
	 */
	private Date fechaIncorporacion;

	/**
	 * Constructor de la clase Buque.
	 *
	 * @param id               Identificador del buque.
	 * @param nombre           Nombre del buque.
	 * @param ubicacionInicial Puerto donde se encuentra inicialmente el buque.
	 */
	public Buque(char id, String nombre, Puerto ubicacionInicial) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacionInicial = ubicacionInicial;
		this.fechaIncorporacion = new Date();
	}

	/**
	 * Método getter para obtener el identificador del buque.
	 *
	 * @return Identificador del buque.
	 */
	public char getId() {
		return id;
	}

	/**
	 * Método setter para establecer el identificador del buque.
	 *
	 * @param id Identificador del buque.
	 */
	public void setId(char id) {
		this.id = id;
	}

	/**
	 * Método getter para obtener el nombre del buque.
	 *
	 * @return Nombre del buque.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter para establecer el nombre del buque.
	 *
	 * @param nombre Nombre del buque.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter para obtener el puerto donde se encuentra inicialmente el
	 * buque.
	 *
	 * @return Puerto donde se encuentra inicialmente el buque.
	 */
	public Puerto getUbicacionInicial() {
		return ubicacionInicial;
	}

	/**
	 * Método setter para establecer el puerto donde se encuentra inicialmente el
	 * buque.
	 *
	 * @param ubicacionInicial Puerto donde se encuentra inicialmente el buque.
	 */
	public void setUbicacionInicial(Puerto ubicacionInicial) {
		this.ubicacionInicial = ubicacionInicial;
	}

	/**
	 * Método getter para obtener la fecha de incorporación del buque.
	 *
	 * @return Fecha de incorporación del buque.
	 */
	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	/**
	 * Método setter para establecer la fecha de incorporación del buque.
	 *
	 * @param fechaIncorporacion Fecha de incorporación del buque.
	 */
	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
}
