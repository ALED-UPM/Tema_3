package es.upm.dit.aled.parking;

/**
 * Monitor para gestion de un parking
 * 
 * @author jpuente
 * @version 30.10.2013
 */
public class Parking {

	private int n = 0; // número de coches en el parking
	
	// entra un coche por una de las puertas
	public synchronized void entra (String puerta) {
		n++;
	}
	
	// sale un coche por una de las puertas
	public synchronized void sale (String puerta) {
		n--;
	}
	
	// consulta 
	public synchronized int ocupado() {
		return n;
	}
}
