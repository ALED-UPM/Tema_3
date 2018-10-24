package es.upm.dit.aled.rw;

/**
 * Monitor para gestionar un conjunto de hebras lectoras y escritoras.
 * Sólo un cliente puede acceder a los datos a la vez, independientemente
 * de que sea lector o escritor.
 *
 * @author jpuente
 * @version 24.10.2018
 */
public class RW_Mutex implements RW {

    private int nr = 0; // número de lectores
    private int nw = 0; // número de escritores

    @Override
    public synchronized void openReading() {
        try {
            while (nr > 0 || nw > 0) wait();
        } catch (InterruptedException ignored) { }
        nr++;
        assert ( (nw == 0 || nr == 0) && nw <= 1 );
    }

    @Override
    public synchronized void closeReading() {
        nr--;
        notifyAll();
    }

    @Override
    public synchronized void openWriting() {
        try {
            while (nr > 0 || nw > 0) wait();
        } catch (InterruptedException ignored) { }
        nw++;
        assert ( (nw == 0 || nr == 0) && nw <= 1 );
    }

    @Override
    public synchronized void closeWriting() {
        nw--;
        notifyAll();
    }

}
