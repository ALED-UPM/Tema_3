package es.upm.dit.aled.rw;

/**
 * Programa de prueba de lectores y escritores
 * 
 * @author aalonso
 * @author jpuente
 * @version 2018.10.24
 */
public class RW_Test {

	public static void main(String[] args) {

		final int nr = 10;
		final int nw =  8;

		RW rw = new RW_Mutex();
//        RW rw = new RW_Readers();
//		RW rw = new RW_Writers();
//		RW rw = new RW_Fair();
		Reader[] lector = new Reader[nr];
		Writer[] escritor = new Writer[nw];

		for (int i = 0; i < nw; i++) {
			escritor[i] = new Writer(rw, i);
			escritor[i].start();
		}
		for (int i = 0; i < nr; i++) {
			lector[i] = new Reader(rw, i);
			lector[i].start();
		}
	}
}
