package es.upm.dit.aled.parking;

import java.util.Random;

/**
 * Sensor de entrada
 * 
 * @author jpuente
 * @version 30.10.2013
 */
public class Sensor extends Thread {

	private String id;
	private Acceso acceso;
	private Parking p;

	// generador para espera aleatoria
	private final Random random = new Random();

	/**
	 * Constructor
	 * 
	 * @param p  Parking
	 * @param acceso Tipo de acceso (ENTRADA, SALIDA)
	 * @param id Nombre del sensor (por ejmplo, "Norte", etc.)
	 */
	public Sensor(Parking p, Acceso acceso, String id) {
		this.p = p;
		this.id = id;
		this.acceso = acceso;
	}

	@Override
	public void run() {
		// espera un tiempo aleatorio y avisa de que pasa un coche
		while (true) {
			try {
				sleep(random.nextInt(5)*1000);
			} catch (InterruptedException e) {
				System.err.println(e.toString());
			}
			switch (acceso) {
				case ENTRADA:	p.entra(id);
								System.out.println("Entra un coche por la entrada " + id);
								break;
				case SALIDA: 	p.sale(id);
								System.out.println("Sale un coche por la salida " + id);
								break;
			}
		}
	}
}

