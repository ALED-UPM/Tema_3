package es.upm.dit.aled.rw;

import java.util.Random;

/**
 * Reader
 * 
 * @author aalonso
 * @author jpuente
 * @version 2018.10.24
 */
public class Reader extends Thread {

	RW rw;
	int id;
	Random random = new Random();

	public Reader(RW rw, int id) {
		this.rw = rw;
		this.id = id;
	}

	public void run() {
		try {
			while (true) {
				sleep(random.nextInt(1000)); // hace otras cosas
				System.out.println("Lector   " +id + " quiere leer");
				rw.openReading();
				System.out.println("Lector   " +id + " empieza a leer");
				sleep(random.nextInt(1500)); // lee
				rw.closeReading();
				System.out.println("Lector   " +id + " termina de leer");
			}
		} catch (InterruptedException ie) {
			return;
		}
	}

}
