package es.upm.dit.aled.parking;

/**
 * Monitor para gestion de un parking
 * 
 * @author jpuente
 * @version 30.10.2013
 */
public class Parking {

	private int n = 0; // número de coches en el parking
	private final int MAX = 5;
	
	// entra un coche por una de las puertas
	public synchronized void entra(String puerta) {

		try {
			while (n == MAX)
				wait();
		} catch (InterruptedException e) {
		}
		n++;
		System.out.println("entra...n = " + n);
		notify();
	}

	// sale un coche por una de las puertas
	public synchronized void sale (String puerta) {
		try {
			while (n <= 0) wait();
		} catch (Exception e) {}
		n--;
		System.out.println("sale...n = " + n);
		notify();
	}
	
	// consulta 
	public synchronized int ocupado() {
		return n;
	}
}
