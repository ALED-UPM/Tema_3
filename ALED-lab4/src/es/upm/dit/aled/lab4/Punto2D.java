package es.upm.dit.aled.lab4;

/**
 * Puntos en 2D.
 * 
 * @author Jose A. Manas
 * @version Sep 18, 2010
 */
public class Punto2D {
	private final double x;
	private final double y;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            abscisa.
	 * @param y
	 *            ordenada.
	 */
	public Punto2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter.
	 * 
	 * @return abscisa.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Getter.
	 * 
	 * @return ordenada.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Pinta el punto. Formato '(x, y)'.
	 * 
	 * @return cadena a imprimir.
	 */
	public String toString() {
		return String.format("(%.3f, %.3f)", x, y);
	}
}

