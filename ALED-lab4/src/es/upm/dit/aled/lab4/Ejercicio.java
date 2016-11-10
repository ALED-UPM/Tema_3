package es.upm.dit.aled.lab4;

import java.awt.*;

/**
 * @author José A. Manas
 * @author Juan A. de la Puente
 * @version 10.09.2014
 */
public class Ejercicio {
	private static final double X_MIN = -4;
	private static final double X_MAX = +4;
	private static final double Y_MIN = -4;
	private static final double Y_MAX = +4;


	public static void main(String[] args) {

		Ventana.fijaEscalaX (X_MIN, X_MAX);
		Ventana.fijaEscalaY(Y_MIN, Y_MAX);

		FuncionP funcion = new Funcion00();
		Gusano gusano = new Gusano(Color.BLUE, funcion, 30);
		gusano.arranca(0, 100, 0.05);
	}
	
}
