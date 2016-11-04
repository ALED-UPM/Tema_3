package es.upm.dit.aled.barbero;

import java.util.Random;

/**
 * Cliente
 * 
 * @author jpuente
 * @version 30.10.2014
 */
public class Cliente extends Thread {

	private Barberia barberia;
	private int id;
	private boolean cortado = false;

	private Random random = new Random();

	/**
	 * Constructor
	 * 
	 * @param barberia
	 * @param id
	 */
	public Cliente(Barberia barberia, int id) {
		this.barberia = barberia;
		this.id = id;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(random.nextInt(5000));
				cortado = barberia.entra(id);
				if (cortado) {
					// espera hasta que le crezca el pelo
					Thread.sleep(5000);
				} else {
					// espera y lo vuelve a intentar
					Thread.sleep(random.nextInt(2000));
				}
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}