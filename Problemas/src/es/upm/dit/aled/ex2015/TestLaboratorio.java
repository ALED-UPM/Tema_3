package es.upm.dit.aled.ex2015;

/**
 * @author jpuente
 * @version 2016.11.10
 */
public class TestLaboratorio {
	
	static final int N = 5;
	static final int I = 10;

	public static void main(String[] args) {
		Laboratorio laboratorio = new Laboratorio(N);
		for (int i = 1; i <=N; i++) {
			new Investigador(i, laboratorio).start();
		}
		new Agente(laboratorio).start();
	}

}
