package es.upm.dit.aled.lab5;

import java.util.Random;

/**
 * Aeronave - puede ser avión o avioneta
 * 
 * @author jpuente
 * @version 06.11.2014
 */
public class Aeronave implements Runnable {

	private long id;
	private Tipo tipo;
	private Pista pista;
	
	private Random random = new Random();
	
	/**
	 * Tiempo de despegue fijo para todas las aeronaves
	 */
	private final long TIEMPO_DESPEGUE = 2000;        // 2 minutos
	private final long TIEMPO_TURBULENCIAS;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            - número de identificación
	 * @param tipo
	 *            - Tipo.AVION o Tipo.AVIONETA
	 * @param pista
	 *            - referencia a la pista de despegue
	 */
	public Aeronave(long id, Tipo tipo, Pista pista) {
		this.id = id;
		this.tipo = tipo;
		this.pista = pista;
		if (tipo == Tipo.AVION) {
			TIEMPO_TURBULENCIAS = 2000;
		} else {
			TIEMPO_TURBULENCIAS = 1000;
		}
	}

	public void run() {
		try {
			System.out.println("Vuelo " + id + " " + tipo);
			// tarda entre 1 y 5 minutos en llegar a la pista
			Thread.sleep (1000 + random.nextInt(4000)); 
			System.out.println("----- " + id + " listo para despegue");
			pista.entra(id, tipo);
			// tarda un tiempo en despegar
			Thread.sleep (TIEMPO_DESPEGUE); 
			pista.despega(id);
			System.out.println("----- " + id + " ha despegado");
			Thread.sleep (TIEMPO_TURBULENCIAS); 
			pista.finTurbulencias();
			System.out.println("----- " + id + " fin de turbulencias");
		} catch (Exception e) {
			System.err.println(">>>>> error: " + e.getMessage());
		}
	}

}
