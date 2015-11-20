package es.upm.dit.aled.puente;

/**
 * @author jpuente
 * @version 2015.11.20
 * 
 * Según el enunciado, puede haber varios coches en el puente 
 * simultáneamente, siempre uqe vayan en la misma dirección.
 * Por el contrario, no puede haber  coches subiendo y bajando
 * simultaneamente. 
 */
public class Puente {
	
	//Número de coches subiendo o bajando
	
    /**
     * Número máximo de coches esperando en una dirección
     */
    private final int MAX = 8;
    
	/**
	 * Número de coches en el puente
	 */
	private int n  = 0;
	
	/**
	 * Dirección que siguen los coches que están actualmente en el puente
	 */
	private Direccion direccionActual;
	
	/**
	 * Número de coches esperando para entrar al puente
	 */
	private int[] esperando = new int[]{0,0}; // 0 para subir, 1 para bajar
	
	public synchronized void entrar(int id, Direccion dir) {
		try {
			System.out.println("El coche " + id + " " + dir + " llega al puente");
			esperando[dir.ordinal()]++;
			System.out.println(">>> " +  n + " coches en el puente; "
			   + esperando[0] + " esperando subir, " + esperando[1] + " esperando bajar");

			while (direccionActual != dir && n > 0
					&& esperando[direccionActual.ordinal()] <= MAX)
				wait();
			System.out.println("El coche " + id + " entra. ");
			direccionActual = dir;
			n++;
			esperando[dir.ordinal()]--;
			
			System.out.println(">>> " +  n + " coches en el puente; "
					   + esperando[0] + " esperando subir, " + esperando[1] + " esperando bajar");
			
		} catch (InterruptedException e) {
		}
	}
	
	public synchronized void salir (int id, Direccion dir) {
		System.out.println("El coche " + id + " sale. ");
		n--;
		System.out.println("<<< " +  n + " coches en el puente; "
				   + esperando[0] + " esperando subir, " + esperando[1] + " esperando bajar");		
		notifyAll();
	}
	
}
