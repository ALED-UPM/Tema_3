package es.upm.dit.aled.lab4;

/**
 * Funciones parametricas.
 *
 * @author Jose A. Manas
 * @version 10.2.2012
 */
public class Funcion00
implements FuncionP {

	/**
	 * Constructor.
	 */
	public Funcion00() {
	}

	/**
	 * Valor de X en función de t.
	 *
	 * @param t parametro.
	 * @return x(t).
	 */
	public double fx(double t) {
		return 2 * Math.cos(t) + Math.cos(8 * t);
	}

	/**
	 * Valor de Y en función de t.
	 *
	 * @param t parametro.
	 * @return y(t).
	 */
	public double fy(double t) {
		return 2 * Math.sin(t) + Math.sin(8 * t);
	}
}
