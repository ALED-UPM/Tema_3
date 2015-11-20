package es.upm.dit.aled.puente;

/**
 * @author jpuente
 * @version 2015.11.20
 */
public class Coche extends Thread{
		
	private int id;
	private Direccion direccion;
	private Puente puente;
	
	private final int tiempoPaso = 2000; // toempo que se tarda en pasar el puente
			
	public Coche (int id, Puente puente, Direccion direccion) {
		this.id  = id;
		this.puente = puente;
		this.direccion = direccion;
	}

	public void run(){		
		try {
			puente.entrar(id, direccion);
			Thread.sleep(tiempoPaso);
			puente.salir(id, direccion);
		} catch (InterruptedException e) {}		
	}
}
