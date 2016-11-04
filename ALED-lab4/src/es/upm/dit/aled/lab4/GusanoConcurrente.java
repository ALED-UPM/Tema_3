package es.upm.dit.aled.lab4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Simula un gusano en la pantalla. Para ello usa una serie finita de puntos de
 * una funcion definida parametricamente (x e y son funcion del tiempo t).
 * 
 * @author Jose A. Manas
 * @author Juan A. de la Puente
 * @version 09.09.2014
 */

public class GusanoConcurrente extends Gusano {

	/**
	 * Papel para dibujar el gusano
	 */
	protected final Papel papel;

	/**
	 * Constructor
	 */
	public GusanoConcurrente(Papel papel, Color color, FuncionP funcion,
			int longitud) {
		super(color, funcion, longitud);
		this.papel = papel;
	}

	@Override
	public void pinta(List<Punto2D> puntos) {
		try {
			for (Object x : trazos) {
				papel.borra(x);
			}
			trazos.clear();

			Punto2D p1 = null;
			for (Punto2D p2 : puntos) {
				papel.ponColor(color);
				if (p1 != null) {
					Object x = papel.pinta(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					trazos.add(x);
				}
				p1 = p2;
			}
			papel.refresca();
		} catch (Exception ignored) {}
	}

}
