package es.upm.dit.aled.ex2014;

/**
 * Prueba del laboratorio
 * 
 * @author jpuente
 * @version 2014.11.10
 */
public class TestLaboratorio {
	
	static final int N = 3; // número de puestos
	static final int M = 2; // número máximo de muestras sin analizar
	static final int I = 5; // número de investigadores

	public static void main(String[] args) {
		
//		Laboratorio laboratorio = new Laboratorio(N);
		Laboratorio laboratorio = new Laboratorio(N, M);
		
		new Analista(laboratorio).start();
		for (int i=1; i <= I; i++) {
			new Investigador(i,laboratorio).start();
		}
	}

}
