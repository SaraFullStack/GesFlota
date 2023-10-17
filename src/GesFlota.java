import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * Clase para la gestión de la flota de buques.
 **/
public class GesFlota {
	/*
	 * Opción seleccionada en el menú.
	 */
	private char opcionSeleccionada;
	/**
	 * Lista de puertos registrados.
	 */
	private List<Puerto> puertos;
	/**
	 * Lista de buques registrados.
	 */
	private List<Buque> buques;
	/**
	 * Lista de operaciones realizadas.
	 */
	private List<Operacion> operaciones;

	/**
	 * Constructor de la clase GesFlota. Inicializa las listas de puertos, buques y
	 * operaciones. Y carga los puertos y buques por defecto.
	 */
	public GesFlota() {
		puertos = new ArrayList<>();
		buques = new ArrayList<>();
		operaciones = new ArrayList<>();

		// Puertos
		puertos.add(new Yacimiento(1, "Yacimiento A"));
		puertos.add(new Refineria(2, "Refinería B"));
		puertos.add(new Deposito(3, "Deposito C"));
		puertos.add(new Yacimiento(4, "Yacimiento D"));
		puertos.add(new Refineria(5, "Refinería E"));
		puertos.add(new Deposito(6, "Deposito F"));
		puertos.add(new Yacimiento(7, "Yacimiento G"));
		puertos.add(new Refineria(8, "Refinería H"));
		puertos.add(new Deposito(9, "Deposito I"));
		puertos.add(new Yacimiento(10, "Yacimiento J"));

		// Buques
		buques.add(new Buque('A', "Buque Alfa", puertos.get(0)));
		buques.add(new Buque('B', "Buque Beta", puertos.get(1)));
		buques.add(new Buque('C', "Buque Gamma", puertos.get(2)));
		buques.add(new Buque('D', "Buque Delta", puertos.get(3)));
		buques.add(new Buque('E', "Buque Epsilon", puertos.get(4)));
	}

	/**
	 * Punto de entrada de la aplicación. Crea una instancia de GesFlota y llama al
	 * método iniciar() para comenzar la ejecución.
	 * 
	 * @param args Argumentos de línea de comandos (no se utilizan en esta
	 *             aplicación).
	 */
	public static void main(String[] args) {
		GesFlota gesFlota = new GesFlota();
		gesFlota.iniciar();
	}

	/**
	 * Método que inicia el programa, muestra el menú y ejecuta la opción
	 * seleccionada por el usuario
	 */
	public void iniciar() {
		do {
			mostrarMenu();
			solicitarOpcion();
			try {
				switch (opcionSeleccionada) {
				case 'P':
					anadirPuerto();
					break;
				case 'B':
					anadirBuque();
					break;
				case 'E':
					estadoBuques();
					break;
				case 'O':
					anadirOperacion();
					break;
				case 'S':
					System.out.println("Saliendo del programa...");
					break;
				case 'R':
					resumenMensual();
					break;
				default:
					System.out.println("Opción no válida. Por favor, intente de nuevo.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			limpiarPantalla();
		} while (opcionSeleccionada != 'S');
	}

	/**
	 * Método que muestra el menú de opciones en la consola.
	 */
	public void mostrarMenu() {
		System.out.println("GesFlota: Gestion de Movimientos de una Flota");
		System.out.println();
		System.out.println("Editar Puerto (Pulsar P)");
		System.out.println("Editar Buque (Pulsar B)");
		System.out.println("Estado Buques (Pulsar E)");
		System.out.println("Operar Buque (Pulsar O)");
		System.out.println("Resumen Mensual Buque (Pulsar R)");
		System.out.println("Salir (Pulsar S)");
		System.out.println();
		System.out.print("Teclear una opción válida (P/B/E/O/R/S): ");
	}

	/**
	 * Solicita al usuario que ingrese una opción del menú y la almacena en la
	 * variable opcionSeleccionada.
	 */
	public void solicitarOpcion() {
		Scanner scanner = new Scanner(System.in);
		opcionSeleccionada = Character.toUpperCase(scanner.next().charAt(0));
		scanner.nextLine();
	}

	/**
	 * Método que limpia la pantalla de la consola.
	 */
	public void limpiarPantalla() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	/**
	 * Añade un nuevo puerto al sistema.
	 */
	public void anadirPuerto() {
		Scanner scanner = new Scanner(System.in);
		int id = 0;
		String nombre;
		char tipo;
		boolean datosCorrectos;

		System.out.print("Identificador (número entre 1 y 10)? ");
		while (!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.print("Por favor, introduzca un número válido: ");
		}
		id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nombre (entre 1 y 20 caracteres)? ");
		nombre = scanner.nextLine();

		do {
			System.out.print("Tipo (Y-Yacimiento, R-Refineria, D-Deposito)? ");
			tipo = Character.toUpperCase(scanner.next().charAt(0));
		} while (tipo != 'Y' && tipo != 'R' && tipo != 'D');

		char decision;
		do {
			System.out.print(
					"IMPORTANTE: Esta opción borra los datos anteriores. Son correctos los nuevos datos (S/N)? ");
			decision = Character.toUpperCase(scanner.next().charAt(0));
			datosCorrectos = decision == 'S';
		} while (!datosCorrectos && decision != 'N');

		if (datosCorrectos) {
			Puerto puerto;
			switch (tipo) {
			case 'Y':
				puerto = new Yacimiento(id, nombre);
				break;
			case 'R':
				puerto = new Refineria(id, nombre);
				break;
			default:
				puerto = new Deposito(id, nombre);
				break;
			}
			for (Puerto p : puertos) {
			    if (p.getId() == puerto.getId()) {
			    	puertos.set(p.getId()-1, puerto);
			        break;
			    }
			}
			System.out.println("Puerto editado correctamente.");
		} else {
			System.out.println("Operación cancelada. Los datos no se han modificado.");
		}
	}

	/**
	 * Permite al usuario añadir un nuevo buque a la flota.
	 */
	public void anadirBuque() {
		Scanner scanner = new Scanner(System.in);
		char id;
		String nombre;
		int idPuertoInicio;
		boolean datosCorrectos;

		do {
			System.out.print("Identificador (letra entre A y E)? ");
			id = Character.toUpperCase(scanner.next().charAt(0));
		} while (id < 'A' || id > 'E');
		scanner.nextLine();

		System.out.print("Nombre (entre 1 y 20 caracteres)? ");
		nombre = scanner.nextLine();

		System.out.println("\nPuertos posibles para la ubicación inicial del buque:");
		for (int i = 0; i < puertos.size(); i++) {
			Puerto puerto = puertos.get(i);
			System.out.printf("%d - %s Tipo: %s\n", i + 1, puerto.getNombre(), puerto.getClass().getSimpleName());
		}

		System.out.print("\nIdentificador de puerto inicio: ");
		idPuertoInicio = scanner.nextInt() - 1;
		scanner.nextLine();

		do {
			System.out.print(
					"IMPORTANTE: Esta opción borra los datos anteriores. Son correctos los nuevos datos (S/N)? ");
			char input = ' ';
			if (scanner.hasNext()) {
				input = Character.toUpperCase(scanner.next().charAt(0));
			}
			datosCorrectos = input == 'S';
		} while (!datosCorrectos && scanner.hasNext() && Character.toUpperCase(scanner.next().charAt(0)) != 'N');

		if (datosCorrectos) {
			Puerto puertoInicial = puertos.get(idPuertoInicio);
			Buque buque = new Buque(id, nombre, puertoInicial);
			for (int i = 0; i < buques.size(); i++) {
		        Buque buqueItem = buques.get(i);
		        if (buqueItem.getId() == buque.getId()) {
		            buques.set(i, buque);
		            break;
		        }
		    }
			System.out.println("Buque editado correctamente.");
		} else {
			System.out.println("Operación cancelada. Los datos no se han modificado.");
		}
	}

	/**
	 * Muestra el estado actual de todos los buques en la flota, incluyendo su
	 * nombre, id, puerto actual, última fecha de operación y la carga que llevan
	 * actualmente.
	 */
	public void estadoBuques() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String[][] datosBuques = new String[buques.size() + 1][6];
		datosBuques[0] = new String[] { "Id", "Nombre", "Puerto", "Última Fecha", "Carga" };
		for (int i = 0; i < buques.size(); i++) {
			Buque buque = buques.get(i);
			String nombre = buque.getNombre();
			String insignia = Character.toString(buque.getId());
			String puerto = "";
			Date ultimaFecha = null;
			Producto carga = null;

			for (int j = operaciones.size() - 1; j >= 0; j--) {
				Operacion operacion = operaciones.get(j);
				if (operacion.getIdBuque() == buque.getId()) {
					puerto = operacion.getOrigen().getNombre();
					ultimaFecha = (Date) operacion.getFechaComienzoOperacion();
					carga = operacion.getProductoCargado();
					break;
				} else if (operacion.getIdBuque() == buque.getId() && operacion.isDescargar()) {
					puerto = "En traslado";
					ultimaFecha = (Date) operacion.getFechaComienzoOperacion();
					carga = operacion.getProductoCargado();
					break;
				} else if (operacion.getIdBuque() == buque.getId() && operacion.isTrasladar()) {
					puerto = operacion.getDestino().getNombre();
					ultimaFecha = (Date) operacion.getFechaComienzoOperacion();
					carga = operacion.getProductoCargado();
					break;
				}
			}

			String ultimaFechaStr = ultimaFecha == null ? "" : formatoFecha.format(ultimaFecha);
			String cargaStr = carga == null ? "Vacio" : carga.getNombre();

			datosBuques[i + 1] = new String[] { insignia, nombre, puerto, ultimaFechaStr, cargaStr };
		}

		for (String[] fila : datosBuques) {
			System.out.format("%-20s%-20s%-23s%-20s%-20s\n", fila);
		}
	}

	/**
	 * Añade una nueva operación al sistema, permitiendo la carga, traslado y
	 * descarga de productos por un buque en un puerto determinado.
	 */
	public void anadirOperacion() {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Fecha comienzo operación: Día? ");
		int dia = scanner.nextInt();
		System.out.print("Fecha comienzo operación: Mes? ");
		int mes = scanner.nextInt();
		System.out.print("Fecha comienzo operación: Año? ");
		int ano = scanner.nextInt();
		String fechaString = dia + "/" + mes + "/" + ano;
		Date fechaComienzoOperacion;
		try {
			fechaComienzoOperacion = (Date) formatoFecha.parse(fechaString);
		} catch (ParseException e) {
			System.out.println("Error al parsear la fecha. Por favor, intente de nuevo.");
			return;
		}

		System.out.print("Identificador del Buque (letra entre A y E)? ");
		char idBuque = scanner.next().charAt(0);

		Buque buqueSeleccionado = null;

		for (Buque buque : buques) {
			if (buque.getId() == idBuque) {
				buqueSeleccionado = buque;
				break;
			}
		}

		if (buqueSeleccionado == null) {
			System.out.println("Buque no encontrado. Por favor, intente de nuevo.");
			return;
		}

		Puerto puertoOrigen = buqueSeleccionado.getUbicacionInicial();

		boolean buqueCargado = false;
		Operacion ultimaOperacion = null;
		int idProducto = 1;
		for (Operacion op : operaciones) {
			if (op.getIdBuque() == buqueSeleccionado.getId()) {
				ultimaOperacion = op;
			}
			if (op.getProductoCargado().getId() > idProducto) {
				idProducto = op.getProductoCargado().getId() + 1;
			}
		}

		if (ultimaOperacion == null || ultimaOperacion.isDescargar()) {
			System.out.println(
					"El buque " + buqueSeleccionado.getNombre() + " está vacío en " + puertoOrigen.getNombre());
			int diasCarga = 0;
			int producto = 0;
			char cargaDescarga = 'a';
			if (puertoOrigen instanceof Yacimiento) {
				System.out.println("Se puede cargar: Crudo");
				System.out.print("Quiere realizar la carga (S/N)? ");
				char cargarCrudo = scanner.next().charAt(0);
				if (cargarCrudo == 'N' || cargarCrudo == 'n') {
					return;
				}
				NoRefinado productoCarga = new NoRefinado(idProducto, "Crudo");
				System.out.print("Duración de la carga en días? ");
				diasCarga = scanner.nextInt();
				operaciones.add(new Operacion(fechaComienzoOperacion, buqueSeleccionado.getId(), true, diasCarga, false,
						0, false, 0, puertoOrigen, null, productoCarga));
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(fechaComienzoOperacion);
				calendario.add(Calendar.DAY_OF_MONTH, diasCarga);
				fechaComienzoOperacion = calendario.getTime();
			} else if (puertoOrigen instanceof Refineria) {
				System.out.println("Se puede cargar: Fuel, Gasoil, Gasolina");
				System.out.print("Quiere realizar la carga (S/N)? ");
				char cargarCrudo = scanner.next().charAt(0);
				if (cargarCrudo == 'N' || cargarCrudo == 'n') {
					return;
				}
				System.out.print("Producto a cargar (1 – Fuel, 2 – Gasoil, 3 – Gasolina)?");
				producto = scanner.nextInt();
				String nombre = "Gasolina";
				switch (producto) {
				case 1:
					nombre = "Fuel";
					break;
				case 2:
					nombre = "Gasoil";
					break;
				}
				Refinado productoCarga = new Refinado(idProducto, nombre);
				System.out.print("Duración de la carga en días? ");
				diasCarga = scanner.nextInt();
				operaciones.add(new Operacion(fechaComienzoOperacion, buqueSeleccionado.getId(), true, diasCarga, false,
						0, false, 0, puertoOrigen, null, productoCarga));
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(fechaComienzoOperacion);
				calendario.add(Calendar.DAY_OF_MONTH, diasCarga);
				fechaComienzoOperacion = calendario.getTime();
			} else if (puertoOrigen instanceof Deposito) {
				System.out.println("Se puede cargar: Fuel, Gasoil, Gasolina");
				System.out.print("Quiere realizar la carga (C), ninguna (N)? ");
				cargaDescarga = scanner.next().charAt(0);
				if (cargaDescarga == 'N' || cargaDescarga == 'n') {
					return;
				} else if (cargaDescarga == 'C' || cargaDescarga == 'c') {
					System.out.print("Producto a cargar (1 – Fuel, 2 – Gasoil, 3 – Gasolina)?");
					producto = scanner.nextInt();
					String nombre = "Gasolina";
					switch (producto) {
					case 1:
						nombre = "Fuel";
						break;
					case 2:
						nombre = "Gasoil";
						break;
					}
					Refinado productoCarga = new Refinado(idProducto, nombre);
					System.out.print("Duración de la carga en días? ");
					diasCarga = scanner.nextInt();
					operaciones.add(new Operacion(fechaComienzoOperacion, buqueSeleccionado.getId(), true, diasCarga,
							false, 0, false, 0, puertoOrigen, null, productoCarga));
					Calendar calendario = Calendar.getInstance();
					calendario.setTime(fechaComienzoOperacion);
					calendario.add(Calendar.DAY_OF_MONTH, diasCarga);
					fechaComienzoOperacion = calendario.getTime();
				}
			}

		}
		for (Operacion op : operaciones) {
			if (op.getIdBuque() == buqueSeleccionado.getId()) {
				ultimaOperacion = op;
			}
		}
		System.out
				.println("El buque " + buqueSeleccionado.getNombre() + " está cargado en " + puertoOrigen.getNombre());
		System.out.print("Quiere realizar el traslado (S/N)? ");
		char realizarTraslado = scanner.next().charAt(0);
		if (realizarTraslado == 'S' || realizarTraslado == 's') {
			System.out.println("Puertos de posible destino del buque:");
			for (Puerto puerto : puertos) {
				if (!puerto.equals(puertoOrigen)) {
					System.out.print(puerto.getId() + " - " + puerto.getNombre());
					if (puerto instanceof Yacimiento) {
						System.out.println(" Tipo: Yacimiento");
					} else if (puerto instanceof Refineria) {
						System.out.println(" Tipo: Refinería");
					} else if (puerto instanceof Deposito) {
						System.out.println(" Tipo: Deposito");
					}
				}
			}
			System.out.print("Identificador del puerto destino? ");
			int idDestino = scanner.nextInt();
			Puerto puertoDestino = null;
			for (Puerto puerto : puertos) {
				if (puerto.getId() == idDestino) {
					puertoDestino = puerto;
					break;
				}
			}
			if (puertoDestino != null) {
				System.out.print("Duración del traslado en días? ");
				int diasTraslado = scanner.nextInt();
				int dias = 0;
				operaciones.add(new Operacion(fechaComienzoOperacion, buqueSeleccionado.getId(), false, 0, true,
						diasTraslado, false, 0, puertoOrigen, puertoDestino, ultimaOperacion.getProductoCargado()));
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(fechaComienzoOperacion);
				calendario.add(Calendar.DAY_OF_MONTH, diasTraslado);
				fechaComienzoOperacion = calendario.getTime();
			} else {
				System.out.println("No se encontró el puerto destino.");
			}
		}
		for (Operacion op : operaciones) {
			if (op.getIdBuque() == buqueSeleccionado.getId()) {
				ultimaOperacion = op;
			}
		}
		if (ultimaOperacion.isTrasladar() && !(ultimaOperacion.getDestino() instanceof Yacimiento)) {
			Producto productoDescargado = ultimaOperacion.getProductoCargado();
			if (productoDescargado == null) {
				System.out.println("El buque no lleva ningún producto.");
				return;
			}
			System.out.println("El buque lleva " + productoDescargado.getNombre());
			if (ultimaOperacion.getDestino() instanceof Refineria) {
				if (!productoDescargado.getNombre().equals("Crudo")) {
					System.out.println("No se puede descargar el producto actual en este puerto.");
					return;
				}
			} else if (ultimaOperacion.getDestino() instanceof Deposito) {
				if (productoDescargado.getNombre().equals("Crudo")) {
					System.out.println("No se puede descargar el producto actual en este puerto.");
					return;
				}
			}
			System.out.print("Quiere realizar la descarga (S/N)? ");
			char cargarCrudo = scanner.next().charAt(0);
			if (cargarCrudo == 'N' || cargarCrudo == 'n') {
				return;
			}
			System.out.print("Duración de la descarga en días? ");
			int diasDescarga = scanner.nextInt();
			operaciones.add(new Operacion(fechaComienzoOperacion, buqueSeleccionado.getId(), false, 0, false, 0, true,
					diasDescarga, puertoOrigen, ultimaOperacion.getDestino(), ultimaOperacion.getProductoCargado()));
		}
	}

	/**
	 * Método que muestra un resumen mensual de las operaciones realizadas por un
	 * buque seleccionado en un mes y año determinados. Se solicita al usuario el
	 * identificador del buque, el mes y el año. Luego se realiza una búsqueda de
	 * las operaciones del buque en el mes y año seleccionados y se calcula el
	 * tiempo total de carga, traslado, descarga y parada del buque. También se
	 * muestra un calendario con los días correspondientes a cada tipo de operación
	 * y una lista de los traslados realizados.
	 */
	public void resumenMensual() {
		Scanner scanner = new Scanner(System.in);
		boolean seguirMostrandoMes = true;

		do {
			System.out.print("Identificador Buque? ");
			char idBuque = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.print("Selección Mes? ");
			int mes = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Selección Año? ");
			int ano = scanner.nextInt();
			scanner.nextLine();
			System.out.println();

			Buque buqueSeleccionado = null;
			for (Buque buque : buques) {
				if (buque.getId() == idBuque) {
					buqueSeleccionado = buque;
					break;
				}
			}

			if (buqueSeleccionado == null) {
				System.out.println("Buque no encontrado.");
				return;
			}

			List<Operacion> operacionesBuqueMes = new ArrayList<>();
			for (Operacion operacion : operaciones) {
				if (operacion.getIdBuque() == idBuque) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(operacion.getFechaComienzoOperacion());
					if (cal.get(Calendar.MONTH) == mes - 1 && cal.get(Calendar.YEAR) == ano) {
						operacionesBuqueMes.add(operacion);
					}
				}
			}

			if (operacionesBuqueMes.isEmpty()) {
				System.out.println("No se encontraron operaciones para el buque en el mes y año seleccionados.");
				return;
			}

			ArrayList <Integer> totalDiasCarga = new ArrayList<>();
			ArrayList <Integer> totalDiasTraslado = new ArrayList<>();
			ArrayList <Integer> totalDiasDescarga = new ArrayList<>();
			ArrayList <Integer> diasCarga = new ArrayList<>();
			ArrayList <Integer> diasTraslado = new ArrayList<>();
			ArrayList <Integer> diasDescarga = new ArrayList<>();
			int trasladoNum = 1;

			Set<String> trasladosRealizados = new HashSet<>();

			for (Operacion operacion : operacionesBuqueMes) {
				if (operacion.isCargar()) {
					totalDiasCarga.add(operacion.getDiasCarga());
					diasCarga.add(operacion.getFechaComienzoOperacion().getDate());
				}

				if (operacion.isTrasladar()) {
					totalDiasTraslado.add(operacion.getDiasTraslado());
					String trasladoRealizado = "Traslado T" + trasladoNum + ": desde "
							+ operacion.getOrigen().getNombre() + " a " + operacion.getDestino().getNombre() + " con "
							+ operacion.getProductoCargado().getNombre();
					trasladosRealizados.add(trasladoRealizado);
					diasTraslado.add(operacion.getFechaComienzoOperacion().getDate());
					trasladoNum++;
				}

				if (operacion.isDescargar()) {
					totalDiasDescarga.add(operacion.getDiasDescarga());
					diasDescarga.add(operacion.getFechaComienzoOperacion().getDate());
				}
			}

			System.out.println("Resumen Buque " + buqueSeleccionado.getNombre());
			System.out.println();

			Calendar cal = Calendar.getInstance();
			cal.set(ano, mes - 1, 1);
			System.out.printf("%22s %s\n\n",
					cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " + ano, "");
			System.out.println("____________________");
			System.out.println("L  M  X  J  V  S  D");

			int diaInicioMes = 1;
			cal = Calendar.getInstance();
			cal.set(ano, mes - 1, diaInicioMes);
			int ultimoDiaMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			int totalDiasParada = ultimoDiaMes;
			int diaActual = 1;
			trasladoNum = 1;

			int primerDiaSemana = cal.get(Calendar.DAY_OF_WEEK);
			int offsetDia = (primerDiaSemana == Calendar.SUNDAY) ? 6 : primerDiaSemana - 2;

			for (int i = 0; i < offsetDia; i++) {
				System.out.print("   ");
			}

			for (int i = 1; i <= ultimoDiaMes; i++) {
				if ( !diasCarga.contains(i) && !diasDescarga.contains(i) && !diasTraslado.contains(i) ) {
					System.out.print(String.format("%02d", i) + " ");
				} else if ( diasCarga.contains(i) ) {
					System.out.print("C  ");
					int posicion = diasCarga.indexOf(i);
					int dias = totalDiasCarga.get(posicion);
					if( dias > 1 ) {
						for( int j = 1; j < dias; j++ ) {
							if ((i + offsetDia) % 7 == 0) {
								System.out.println();
							}
							System.out.print("C  ");
							i++;
						}
					}
				} else if ( diasTraslado.contains(i) ) {
					System.out.print("T" + trasladoNum + " ");
					int posicion = diasTraslado.indexOf(i);
					int dias = totalDiasTraslado.get(posicion);
					if( dias > 1 ) {
						for( int j = 1; j < dias; j++ ) {
							if ((i + offsetDia) % 7 == 0) {
								System.out.println();
							}
							System.out.print("T" + trasladoNum + " ");
							i++;
						}
					}
					trasladoNum++;
				} else if ( diasDescarga.contains(i) ) {
					System.out.print("D  ");
					int posicion = diasDescarga.indexOf(i);
					int dias = totalDiasDescarga.get(posicion);
					if( dias > 1 ) {
						for( int j = 1; j < dias; j++ ) {
							if ((i + offsetDia) % 7 == 0) {
								System.out.println();
							}
							System.out.print("D  ");
							i++;
						}
					}
				}  else {
					System.out.print("   ");
				}
				if ((i + offsetDia) % 7 == 0) {
					System.out.println();
				}
			}

			System.out.println();
			int totalDias = 0;
			for( int d : totalDiasCarga ) totalDias += d;
			totalDiasParada -= totalDias;
			System.out.println("Tiempo de cargas (C): " + totalDias + " días");
			totalDias = 0;
			for( int d : totalDiasTraslado ) totalDias += d;
			totalDiasParada -= totalDias;
			System.out.println("Tiempo de traslados (T#): " + totalDias + " días");

			if (!trasladosRealizados.isEmpty()) {
				System.out.println("Traslados realizados:");

				for (String trasladoRealizado : trasladosRealizados) {
					System.out.println("- " + trasladoRealizado);
				}
			}

			totalDias = 0;
			for( int d : totalDiasDescarga ) totalDias += d;
			totalDiasParada -= totalDias;
			System.out.println("Tiempo de descargas (D): " + totalDias + " días");
			System.out.println("Tiempo de parada: " + totalDiasParada + " días");

			System.out.print("Mostrar otro mes? (S/N): ");
			char respuesta = scanner.nextLine().charAt(0);
			if (respuesta == 'S' || respuesta == 's') {
				seguirMostrandoMes = true;
			} else if (respuesta == 'N' || respuesta == 'n') {
				seguirMostrandoMes = false;
			} else {
				System.out.println("Respuesta no válida. Intente de nuevo.");
				return;
			}

		} while (seguirMostrandoMes);
	}
}
