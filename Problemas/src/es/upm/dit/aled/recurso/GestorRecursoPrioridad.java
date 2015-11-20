package es.upm.dit.aled.recurso;

/**
 * @author jpuente
 * @version 2015.11.20
 */
class GestorRecursoPrioridad {

	// Esta variable indica si el recurso está libre
	private Boolean recursoLibre = true;

	// Variables para saber cuantas hebras de cada prioridad están
	// esperando en el monitor
	private int nAlta = 0;
	private int nMedia = 0;

	public synchronized void solicitarAlta() {

		nAlta = nAlta + 1;
		try {
			while (!recursoLibre)
				wait();
		} catch (InterruptedException ie) {
		}

		nAlta = nAlta - 1;
		recursoLibre = false;
	}

	public synchronized void solicitarMedia() {

		nMedia = nMedia + 1;

		try {
			while (!recursoLibre || nAlta > 0)
				wait();
		} catch (InterruptedException ie) {
		}

		nMedia = nMedia - 1;
		recursoLibre = false;
	}

	public synchronized void solicitarBaja() {

		try {
			while (!recursoLibre || nAlta > 0 || nMedia > 0)
				wait();
		} catch (InterruptedException ie) {
		}

		recursoLibre = false;
	}

	public synchronized void liberar() {

		recursoLibre = true;
		notifyAll();

	}

}
