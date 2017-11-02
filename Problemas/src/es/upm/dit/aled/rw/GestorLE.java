package es.upm.dit.aled.rw;

/**
 * Monitor para gestionar un conjunto de hebras lectoras y escritoras. Ninguna
 * tiene prioridad frente a las otras. Si hay lectores continuamente entrando,
 * los escritores nunca entrarán: situación de hambruna (inanición).
 * 
 * @author aalonso
 * @author jpuente
 * @version 04.11.2014
 */
public class GestorLE implements Gestor {

	private boolean bloqueoEscritor = false;
	private boolean bloqueoLector = false;
	private int nLectores = 0;

	public synchronized void empiezaLeer(int idLector) {

		if (bloqueoEscritor)
			System.out.println("LLLLL La hebra lectora " + idLector
					+ " se ha bloqueado");

		while (bloqueoEscritor) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		bloqueoLector = true;
		nLectores++;

		System.out.println("L>>>> La hebra lectora " + idLector
				+ " tiene permiso para leer");
	}

    public synchronized void empiezaEscribir(int idEscritor) {

        if (bloqueoEscritor || bloqueoLector)
            System.out.println("EEEEE La hebra escritora " + idEscritor
                    + " se ha bloqueado");

        while (bloqueoEscritor || bloqueoLector) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        bloqueoEscritor = true;

        System.out.println("E>>>> La hebra escritora " + idEscritor
                + " tiene permiso para escribir");
    }

	public synchronized void terminaLeer(int idLector) {
		System.out.println("L<<<< La hebra lectora " + idLector
				+ " ha terminado de leer");

		nLectores--;
		if (nLectores == 0) {
			bloqueoLector = false;
			notifyAll();
		}
	}

	public synchronized void terminaEscribir(int idEscritor) {

		System.out.println("E<<<< La hebra escritora " + idEscritor
				+ " ha terminado de escribir");

		bloqueoEscritor = false;
		notifyAll();
	}
}