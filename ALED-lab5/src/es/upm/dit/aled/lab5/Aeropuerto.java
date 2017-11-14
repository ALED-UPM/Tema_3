package es.upm.dit.aled.lab5;

import java.util.Random;

/**
 * Aeropuerto
 * 
 * @author jpuente
 * @version 2017.11.14
 */
public class Aeropuerto {
	
	private static final Random random = new Random();
	private static final Pista pista = new Pista();
	
	private static volatile boolean activo = true;
	
	// hebra auxiliar para detener la simulación
	private static Thread para = new Thread() {
		public void run() {
			try {
				sleep(60000);
			} catch (Exception e) {
				System.err.println("ERROR " + e.getMessage());
			}
			activo = false;
		}
	};

	// método principal
	public static void main(String[] args) {
		long vuelo = 1000;
		System.out.println ("Comienzo de la simulación");
		para.start();
		try {
			// ahora se van creando aeronaves mientras la simulación esté activa
			while (activo) {
				// tiempo hasta que salga una nueva aeronave
				Thread.sleep(random.nextInt(1000));
				new Thread(new Aeronave(vuelo++, Tipo.random(), pista)).start();
			}
		} catch (Exception e) {
			System.err.println("ERROR " + e.getMessage());
		}
		System.out.println ("Fin de la simulación --- las aeronaves activas siguen ejecutándose");
	}

}
