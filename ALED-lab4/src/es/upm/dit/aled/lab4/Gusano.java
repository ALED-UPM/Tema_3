package es.upm.dit.aled.lab4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Simula un gusano en la pantalla. Para ello usa una serie finita de puntos de
 * una funcion definida paramétricamente (x e y son funcion del tiempo t).
 * 
 * @author Jose A. Manas
 * @author Juan A. de la Puente
 * @version 09.09.2014
 */

public class Gusano {

	protected final Color color;
	protected final FuncionP funcion;
	protected final Cola cola;

	/**
	 * Lista de trazos pintados en la ventana que forman la figura del gusano.
	 */
	protected List<Object> trazos = new ArrayList<Object>();

	/**
	 * Constructor. Prepara el gusano.
	 * 
	 * @param color
	 *            color de los trazos.
	 * @param funcion
	 *            función paramétrica que va generando valores sucesivos.
	 * @param longitud
	 *            número maximo de trazos que componen el gusano.
	 */
	public Gusano(Color color, FuncionP funcion, int longitud) {
		this.color = color;
		this.funcion = funcion;
		this.cola = new Cola(longitud);
	}

	/**
	 * Pone en marcha el gusano.
	 * 
	 * @param desde
	 *            punto de partida: instante de tiempo en el que arranca.
	 * @param hasta
	 *            punto final: instante de tiempo en el que para.
	 * @param dt
	 *            incrementos de tiempo entre cálculos de posicion.
	 */
	public void arranca(double desde, double hasta, double dt) {
		double t = desde;
		while (t < hasta) {
			double x = funcion.fx(t);
			double y = funcion.fy(t);
			Punto2D punto = new Punto2D(x, y);
			cola.mete(punto);
			pinta(cola.puntos());
			try { Thread.sleep(100); }
			catch (InterruptedException e) { System.err.println("Error sleeping"); }
			t += dt;
		}
	}
	
	/**
	 * Limpia el dibujo y pinta los trazos que forman el gusano
	 * 
	 * @param puntos
	 *            serie de puntos que componen el trazo a pintar.
	 * @param espera
	 *            tiempo de espera después de pintar en segundos
	 * @return
	 *            lista actualizada de tramos pintados
	 */
	public void pinta(List<Punto2D> puntos) {
		try {
			for (Object x : trazos) {
				Ventana.borra(x);
			}
			trazos.clear();

			Punto2D p1 = null;
			for (Punto2D p2 : puntos) {
				Ventana.ponColor(color);
				if (p1 != null) {
					Object x = Ventana.pinta(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					trazos.add(x);
				}
				p1 = p2;
			}
			Ventana.refresca();
		} catch (Exception ignored) {}
	}

}
