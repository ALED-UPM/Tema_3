package es.upm.dit.aled.parking;

/**
 * Supervisor del parking
 * 
 * @author jpuente
 * @version 15.10.2014
 */
public class Supervisor extends Thread {
	
	private Parking p;
	
	/**
	 * Constructor
	 * 
	 * @param p Parking que se gestiona
	 */
	public Supervisor(Parking p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		// comprueba el estado del parking cada 10 s
		while (true) {
			System.out.println(">>>> Número de plazas ocupadas: " + p.ocupado());
			try {
				sleep(10*1000);
			} catch (InterruptedException e) {
				System.err.println(e.toString());
			}
		}
	}

}
