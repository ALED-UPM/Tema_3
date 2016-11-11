/**
 * 
 */
package es.upm.dit.aled.ex2014;

import java.util.Random;

/**
 * Analista
 * 
 * @author jpuente
 * @version 2016.11.10
 */
public class Analista extends Thread{
	
	private final Laboratorio laboratorio;
	private final Random random = new Random();

	/**
	 * Constructor
	 * 
	 * @param laboratorio - referencia al laboratorio
	 */
	public Analista (Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	
	@Override
	public void run() {
		while (true) {
			try {
				laboratorio.recogeMuestra();
				System.out.println("El analista ha recogido una muestra");
				sleep(random.nextInt(2000));  // analiza
				System.out.println("El analista entrega el resultado");
				laboratorio.entregaResultado();
			} catch (InterruptedException e) {}
		}
	}

}
