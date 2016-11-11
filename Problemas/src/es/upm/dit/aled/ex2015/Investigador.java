package es.upm.dit.aled.ex2015;

import java.util.Random;

/**
 * Investigador
 * 
 * @author jpuente
 * @version 2016.11.10
 */
public class Investigador extends Thread {
	
	private final int id;
	private final Laboratorio laboratorio;
	private final Random random = new Random();
	
	public Investigador (int id, Laboratorio laboratorio) {
		this.id = id;
		this.laboratorio = laboratorio;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				sleep(random.nextInt(3000)); // otras actividades
				laboratorio.toma();
				System.out.println("El investigador " + id + " está usando un instrumento");
				sleep(random.nextInt(1000)); // usa el instrumento
				laboratorio.devuelve();
				System.out.println("El investigador " + id + " ha devuelto el instrumento");
			} catch (InterruptedException e) {
			}
		}
	}

}
