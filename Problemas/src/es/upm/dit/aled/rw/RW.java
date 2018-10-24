package es.upm.dit.aled.rw;

/**
 * Interfaz con las operaciones necesarias para gestionar un conjunto de
 * lectores y escritores
 *
 * Invariante: (NR > 0 => NW = 0) & (NW > 0 => NR = 0) & (NW <= 1)
 * 
 * @author aalonso
 * @author jpuente
 * @version 24.10.2018
 * 
 */
public interface RW {

	/**
	 * Método que invoca un lector antes de comenzar a leer
	 */
	public void openReading();

	/**
	 * Método que invoca un lector al terminar de leer
	 */
	public void closeReading();

	/**
	 * Método que invoca un escritor antes de comenzar a escribir
	 */
	public void openWriting();

	/**
	 * Método que invoca un escritor al terminar de escribir
	 */
	public void closeWriting();
}
