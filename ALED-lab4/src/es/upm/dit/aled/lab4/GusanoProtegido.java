package es.upm.dit.aled.lab4;

import java.awt.Color;
import java.util.List;

public class GusanoProtegido 
	extends GusanoConcurrente {
	
	/**
	 * Constructor
	 */
	public GusanoProtegido(Papel papel, Color color, FuncionP funcion,
			int longitud) {
		super(papel, color, funcion, longitud);
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
				if (p1 != null) {
					Object x = papel.pinta(color, p1.getX(), p1.getY(), p2.getX(), p2.getY());
					trazos.add(x);
				}
				p1 = p2;
			}
			papel.refresca();
		} catch (Exception ignored) {}
	}

}
