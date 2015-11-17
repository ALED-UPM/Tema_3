package es.upm.dit.aled.lab5;

import java.util.Random;

/**
 * Aeropuerto
 * 
 * @author jpuente
 * @version 06.11.2014
 */
public class Aeropuerto {
	
	static final Random random = new Random();
	static final Pista pista = new Pista();
	
	static volatile boolean activo = true;

	public static void main(String[] args) {
		long vuelo = 1000;
		try {		
			while (activo) {
				// tiempo hasta que salga una nueva aeronave
				Thread.sleep (random.nextInt(5000)); 
				new Thread(new Aeronave(vuelo++, Tipo.random(), pista)).start();	
			}
		} catch (Exception e) {
			System.err.println("ERROR " + e.getMessage());
		}
	}

}
