package es.upm.dit.aled.barbero;

/**
 * Problema del barbero durmiente
 * 
 * @author jpuente
 * @version 30.10.2014
 */
public class PruebaBarberia {

	public static void main(String[] args) {

		final int nSillas = 2;
		final int nClientes = 5;
		Barberia barberia = new Barberia(nSillas);
		Barbero barbero = new Barbero(barberia);
		Cliente[] cliente = new Cliente[nClientes];

		barbero.start();
		for (int i = 0; i < nClientes; i++) {
			cliente[i] = new Cliente(barberia, i);
			cliente[i].start();
		}
	}
}
