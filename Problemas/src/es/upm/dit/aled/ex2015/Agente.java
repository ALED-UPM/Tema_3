package es.upm.dit.aled.ex2015;

import java.util.Random;

/**
 * Técnico de mantenimiento
 * 
 * @author jpuente
 *
 */
public class Agente extends Thread {
	
	private final Laboratorio laboratorio;
	private final Random random = new Random();

	/**
	 * Constructor
	 * 
	 * @param laboratorio - referencia al laboratorio
	 */
	public Agente (Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	
	@Override
	public void run() {
		while (true) {
			try {
				sleep(random.nextInt(10000));
				System.out.println("El técnico espera para revisar");
				laboratorio.revisa();
				System.out.println("El técnico está revisando los instrumentos");
				sleep(random.nextInt(2000));  // revisa
				System.out.println("El técnico ha terminado la revisión");
				laboratorio.termina();
			} catch (InterruptedException e) {}
		}
	}
}
