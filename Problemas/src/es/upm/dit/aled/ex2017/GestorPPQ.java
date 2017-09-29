package es.upm.dit.aled.ex2017;

public class GestorPPQ {
	
	private boolean ocupado = false;
	private int turno = 0; // 0, 1 : P; 2 : Q

	public synchronized void entraP() {
		while (ocupado || turno == 2) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		ocupado = true;
	}

	public synchronized void entraQ() {
		while (ocupado || turno != 2) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		ocupado = true;
	}

	public synchronized void sale() {
		turno = ++turno % 3;
		ocupado = false;
		notifyAll();
	}

}
