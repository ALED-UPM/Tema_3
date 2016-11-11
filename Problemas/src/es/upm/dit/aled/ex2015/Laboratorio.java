package es.upm.dit.aled.ex2015;

/**
 * Laboratorio
 * 
 * @author jpuente
 * @versino 2016.11.10
 */
public class Laboratorio {

	private final int N;  // número de instrumentos
	private int disponibles;
	private boolean revisando = false;
	
	/**
	 * Constructor
	 * 
	 * @param N - número de instrumentos en el laboratorio
	 */
	public Laboratorio (int N) {
		this.N = N;
		disponibles = N;
	}

	/**
	 * Toma un instrumento si está disponible, si no espera
	 */
	public synchronized void toma() {
		try {
			while (disponibles <= 0 || revisando)
				wait();
			disponibles--;
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Devuelve un instrumento
	 */
	public synchronized void devuelve() {
		disponibles++;
		notifyAll();
	}
	
	/**
	 * El técnico revisa los instrumentos; espera a que estén libres
	 */
	public synchronized void revisa() {
		revisando = true;
		try {
			while (disponibles < N)
				wait();
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 * EL técnico termina de revisar los instrumentos
	 */
	public synchronized void termina() {
		revisando = false;
		notifyAll();
	}
}
