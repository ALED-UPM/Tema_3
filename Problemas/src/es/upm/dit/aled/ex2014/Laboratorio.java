package es.upm.dit.aled.ex2014;

/**
 * Acceso a un laboratorio
 * 
 * @author jpuente
 * @version 2016.11.10
 */
public class Laboratorio {

	private final int N; // número de puestos
	private final int M;     // número máximo de muestras pendientes
	private int ocupados = 0;
	private int pendientes = 0;

	private boolean terminado = false;

	/**
	 * Constructor
	 * 
	 * @param N
	 *            - número de puestos de trabajo en el laboratorio
	 */
//	public Laboratorio(int N) {
    public Laboratorio(int N, int M) {
		this.N = N;
		this.M = M;
	}

	/**
	 * Un investigador entra al laboratorio
	 * 
	 * @return verdadero si ha entrado (no espera)
	 */
	public synchronized boolean entra() {
		if (ocupados < N) {
			ocupados++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Entrega una muestra para analizar
	 */
	public synchronized void entregaMuestra() {
		try {
			while (pendientes >= M)
				wait();
		} catch (InterruptedException e) {}
			
		pendientes++;
		terminado = false;
		notifyAll(); // avisa al analista
	}

	/**
	 * Espera el resultado del análisis
	 */
	public synchronized void esperaResultado() {
		try {
			while (!terminado)
				wait();
		} catch (InterruptedException e) {}
	}

	/**
	 * El investigador sale del laboratorio
	 */
	public synchronized void sale() {
		ocupados--;
	}

	/**
	 * El analista recoge una muestra para analizar
	 */
	public synchronized void recogeMuestra() {
		try {
			while (pendientes == 0)
				wait();
			pendientes--;
			notifyAll();
		} catch (Exception e) {}
	}

	/**
	 * El analista entrega el resultado del análisis
	 */
	public synchronized void entregaResultado() {
		terminado = true;
		notifyAll(); // avisa al investigador
	}

}