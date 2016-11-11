/**
 * 
 */
package es.upm.dit.aled.ex2014;

import java.util.Random;

/**
 * Investigador
 * 
 * @author jpuente
 * @version 2016.11.10
 */
public class Investigador extends Thread  {

	private final int id;
	private final Laboratorio laboratorio;
	
	private final Random random = new Random();
	
	/**
	 * Constructor 
	 * 
	 * @param id - identidad del investigador
	 * @param laboratorio - referencia al laboratorio
	 */
	public Investigador(int id, Laboratorio laboratorio) {
		this.id = id;
		this.laboratorio = laboratorio;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				sleep(random.nextInt(5000)); // trabaja en otra cosa
				if ( laboratorio.entra() ) {
					System.out.println("El investigador " + id +  " entra al laboratorio");
					System.out.println("El investigador " + id +  " entrega una muestra");				
					laboratorio.entregaMuestra();
					laboratorio.esperaResultado();
					System.out.println("El investigador " + id +  " recoge el resultado");				
					laboratorio.sale();		
					System.out.println("El investigador " + id +  " sale del laboratorio");				
				} else {
					System.out.println("El investigador " + id +  " no puede entrar, está lleno");				
				}
			} catch (InterruptedException e) {}

		}
	}

}
