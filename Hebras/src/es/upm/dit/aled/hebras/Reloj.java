package es.upm.dit.aled.hebras;

/**
 * Reloj que escribe la hora cada segundo
 * y produce un sonido cuando se pulsa INTRO
 * 
 * @author jpuente
 * @version 2016.10.17
 */
public class Reloj {

	/**
	 * @param args -- no hay argumentos
	 */
	public static void main(String[] args) {
		Hora hora   = new Hora () ;          // crea las hebras
		Sonido sonido = new Sonido();
		hora.start();                        // ... y las arranca
		sonido.start();
	}

}




