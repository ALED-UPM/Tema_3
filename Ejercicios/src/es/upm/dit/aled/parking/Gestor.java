package es.upm.dit.aled.parking;

/**
 * Gestor del parking 
 * 
 * @author jpuente
 * @verisn 30.10.2013
 *
 */
public class Gestor {

	/**
	 * @param args -- no hay argumentos
	 */
	public static void main(String[] args) {
		Parking p = new Parking();
		Sensor entradaSur = new Sensor(p, Acceso.ENTRADA, "sur");
		Sensor entradaNorte = new Sensor(p,Acceso.ENTRADA, "norte");
		Sensor salidaSur = new Sensor(p, Acceso.SALIDA, "sur");
		Supervisor  s = new Supervisor(p);
		entradaSur.start(); 
		entradaNorte.start(); 
		salidaSur.start();
		s.start();
	}

}

