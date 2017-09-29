package es.upm.dit.aled.lab5;

/**
 * Pista de despegue
 * 
 * @author jpuente
 * @version 04.12.2014
 */
public class Pista {


	/**
	 * Pista ocupada
	 */
	private boolean ocupada = false;
	
	/**
	 * Turbulencias
	 */
	private boolean turbulencias = false;
	
	/**
	 * Tipo de la última aeronave que ha despegado
	 */
	private Tipo ultimo = null;
	
	private int avionesEsperando = 0;

	/**
	 * Las aeronaves invocan este método cuando llegan a la pista.
	 * Debe modificarse el código de forma que la aeronave espere si
	 * no se cumplen las condiciones para el despegue.
	 * 
	 * @param vuelo
	 * @param tipo 
	 */
	public synchronized void entra(long vuelo, Tipo tipo) {
		try {
			if (tipo == Tipo.AVION) avionesEsperando++;
			while (tipo == Tipo.AVIONETA && ultimo == Tipo.AVIONETA 
					&& avionesEsperando > 0)
				wait();	
			// espera que la pista esté libre
			while (ocupada) wait();
			ocupada = true;
			if (tipo == Tipo.AVION) avionesEsperando--;			
			// ahora espera que no haya turbulencias
			while(turbulencias) wait();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("----- " + vuelo + " " + tipo + " entra en pista");
	}

	/**
	 * Las aeronaves invocan este método cuando despegan.
	 * 
	 * @param vuelo
	 */	
	public synchronized void despega(long vuelo) {
		ocupada = false;
		turbulencias = true;
		notifyAll();
		System.out.println("----- " + vuelo + " despega");
	}

	/**
	 * Las aeronaves invovan este método para indicar que han 
	 * terminado las turbulencias
	 */
	public synchronized void finTurbulencias() {
		turbulencias = false;
		notifyAll();
		System.out.println("----- " +"fin de turbulencias");
	}

}
