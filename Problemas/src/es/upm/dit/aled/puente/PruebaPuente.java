package es.upm.dit.aled.puente;

import java.util.Random;

public class PruebaPuente {
	
	public static void main(String[] args) {

		Random random = new Random();
		
		boolean activo = true;
		Puente puente = new Puente();
		int id = 0;
		
		while (activo) {
			try {
				Thread.sleep(1000 + random.nextInt(1000));
				new Coche(id, puente, Direccion.random()).start();
				id++;
			} catch (InterruptedException e) {}	
		}

		
	}
}
