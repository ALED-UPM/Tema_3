package es.upm.dit.aled.lab5;

/**
 * Pista de despegue
 * 
 * @author jpuente
 * @version 2016.11.10
 */
public class Pista {

	/**
	 * Las aeronaves invocan este método cuando llegan a la pista.
	 * Debe modificarse el código de forma que la aeronave espere si
	 * no se cumplen las condiciones para el despegue.
	 * 
	 * @param vuelo
	 * @param tipo 
	 */
	public void entra(long vuelo, Tipo tipo) {
		System.out.println("----- " + vuelo + " " + tipo + " entra en pista");
	}

	/**
	 * Las aeronaves invocan este método cuando despegan.
	 * 
	 * @param vuelo
	 */	
	public void despega(long vuelo) {
		System.out.println("----- " + vuelo + " despega");
	}
	
	/**
	 * Las aeronaves invovan este método para indicar que han 
	 * terminado las turbulencias
	 */
	public synchronized void finTurbulencias() {
		System.out.println("----- " +"fin de turbulencias");
	}

}
