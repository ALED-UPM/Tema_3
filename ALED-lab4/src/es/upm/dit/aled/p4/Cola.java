package es.upm.dit.aled.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Cola de tamaño limitado. Lo primero que entre es lo primero que sale. Si se
 * sobrepasa la longitud maxima, se saca el primero.
 * 
 * @author jam
 * @date 7.2.2012
 * 
 */
public class Cola {
	private final List<Punto2D> puntos = new ArrayList<Punto2D>();
	private final int longitud;

	/**
	 * Constructor.
	 * 
	 * @param longitud
	 *            maximo numero de elementos.
	 * 
	 */
	public Cola(int longitud) {
		this.longitud = longitud;
	}

	/**
	 * 
	 * @return numero de puntos almacenados.
	 */
	public int size() {
		return puntos.size();
	}

	/**
	 * Mete al final de la cola. Si se pasa de longitud, se saca el primero.
	 * 
	 * @param punto
	 */
	public void mete(Punto2D punto) {
		puntos.add(punto);
		if (puntos.size() > longitud)
			saca();
	}

	/**
	 * 
	 * @return saca el primer punto de la cola.
	 */
	public Punto2D saca() {
		return puntos.remove(0);
	}

	/**
	 * Getter.
	 * 
	 * @return puntos almacenados.
	 */
	public List<Punto2D> puntos() {
		return puntos;
	}
}


