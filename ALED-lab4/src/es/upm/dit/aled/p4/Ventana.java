package es.upm.dit.aled.lab4;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Interfaz gráfica - versión simplificada de StdDraw
 * 
 * @author jpuente
 * @version 20140912
 * 
 */
@SuppressWarnings("serial")
public class Ventana extends JPanel {

	public static final String TITULO = "Gusano";

	// dimensiones del lienzo
	private static final int LADO = 500;
	private static final double BORDE = 0.05; // el borde ocupa el 5 %

	// escalas horizontal y vertical
	private static double xmin, ymin, xmax, ymax;

	// color
	private static Color color;

	// lista de trazos que hay que pintar
	private static java.util.List<Trazo> trazos;

	// singleton: sólo hay una ventana
	private static final Ventana ventana = new Ventana();

	/**
	 * Constructor
	 */
	private Ventana() {
		JFrame frame = new JFrame(TITULO);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(LADO, LADO));
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setFocusable(true);
		frame.pack();
		frame.setVisible(true);
		requestFocusInWindow();

		fijaEscalaX(0.0, 1.0);
		fijaEscalaY(0.0, 1.0);
		ponColor(Color.BLACK);

		trazos = new ArrayList<Trazo>();
	}

	/**
	 * Escala horizontal
	 */
	public static void fijaEscalaX(double min, double max) {
		double ancho = max - min;
		xmin = min - BORDE * ancho;
		xmax = max + BORDE * ancho;
	}

	/**
	 * Escala vertical
	 */
	public static void fijaEscalaY(double min, double max) {
		double alto = max - min;
		ymin = min - BORDE * alto;
		ymax = max + BORDE * alto;
	}

	/**
	 * Fija el color para dibujar
	 */
	public static void ponColor(Color c) {
		color = c;
	}

	/**
	 * Pinta la pantalla.
	 */
	public static void refresca() {
		ventana.repaint();
	}

	/**
	 * Pinta un trazo (coordenadas en pixeles)
	 * 
	 * @return el objeto pintado
	 */
	private static Object pinta(int x1, int y1, int x2, int y2, Color color) {
		Trazo trazo = ventana.new Trazo(x1, y1, x2, y2, color);
		synchronized (trazos) {
			trazos.add(trazo);
		}
		return (trazo);
	}

	/**
	 * Pinta una línea desde (x0, y0) a (x1, y1) (coordenadas de la aplicación)
	 * 
	 * @return el objeto pintado
	 */
	public static Object pinta(double x0, double y0, double x1, double y1) {
		if (color != null) {
			return pinta(escalaX(x0), escalaY(y0), escalaX(x1), escalaY(y1),
					color);
		} else {
			return null;
		}
	}

	/**
	 * Borra un objeto
	 * 
	 * @param trazo
	 */
	public static void borra(Object trazo) {
		synchronized (trazos) {
			trazos.remove(trazo);
		}
	}

	/**
	 * Borra todo
	 */
	public static void borra() {
		synchronized (trazos) {
			trazos.clear();
		}
	}

	// funciones auxiliares
	private static int escalaX(double x) {
		return (int) (LADO * (x - xmin) / (xmax - xmin));
	}

	private static int escalaY(double y) {
		return (int) (LADO * (ymax - y) / (ymax - ymin));
	}

	/**
	 * Llamada por el entorno de ejecución para pintarse en la pantalla.
	 * 
	 * @param g
	 *            objeto gráfico 2D para dibujarse.
	 */
	@Override
	public void paint(Graphics g) {
		synchronized (trazos) {
			Graphics2D g2 = (Graphics2D) g;

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());

			for (Trazo trazo : trazos) {
				trazo.pinta(g2);
			}
		}
	}

	/**
	 * Clase interna para representar los trazos
	 */
	private class Trazo {
		private final Shape shape;
		private final Color color;

		Trazo(int x1, int y1, int x2, int y2, Color color) {
			this.shape = new Line2D.Double(x1, y1, x2, y2);
			this.color = color;
		}

		public void pinta(Graphics2D g) {
			if (color != null) {
				g.setColor(color);
				g.draw(shape);
			}
		}
	}

}
