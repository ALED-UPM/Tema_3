package es.upm.dit.aled.servicios;

/**
 * @author jpuente
 * @version 2015.11.20
 */
public class gestorRecursosServicios { 

	private boolean [] recursoOcupado = new boolean[] {false, false, false};

	public synchronized void liberarRecurso(Recurso recurso) {

		switch (recurso) {
			case R1: {
				recursoOcupado[0] = false;
				break;
			}
			case R2: {
				recursoOcupado[1] = false;
				break;
			}
			case R3: {
				recursoOcupado[2] = false;
				break;
			}
		}
		notifyAll();
	}
	
	public synchronized void solicitarServicio(Servicio servicio) {
		try {
			switch (servicio) {
				case S1: {
					while (recursoOcupado[0] || recursoOcupado[1])
						wait();
					recursoOcupado[0] = true;
					recursoOcupado[1] = true;
					break;
				}
				case S2: {
					while (recursoOcupado[1] || recursoOcupado[2])
						wait();
					recursoOcupado[1] = true;
					recursoOcupado[2] = true;
					break;
				}
				case S3: {
					while (recursoOcupado[0] || recursoOcupado[2])
						wait();
					recursoOcupado[0] = true;
					recursoOcupado[1] = true;
					break;
				}
			}
		} catch (InterruptedException e) {
		}

	}
	
}

