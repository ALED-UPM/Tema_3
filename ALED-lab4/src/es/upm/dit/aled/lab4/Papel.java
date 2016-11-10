package es.upm.dit.aled.lab4;

import java.awt.Color;

/**
 * Papel para pintar. Recubre la clase Ventana.
 * 
 * @author jpuente
 * @version 20141001
 */
public class Papel {

	public synchronized void ponColor(Color color) {
		Ventana.ponColor(color);
	}

	public synchronized void borra() {
		Ventana.borra();
	}

	public synchronized void borra(Object x) {
		Ventana.borra(x);
	}

	public synchronized Object pinta(double x0, double y0, 
			double x1, double y1) {
		return Ventana.pinta(x0, y0, x1, y1);
	}
	
	public synchronized Object pinta(Color color, double x0, double y0, 
			double x1, double y1) {
		Ventana.ponColor(color);
		return Ventana.pinta(x0, y0, x1, y1);
	}

	public synchronized void refresca() {
		Ventana.refresca();
	}

}
