package es.upm.dit.aled.rw;

/**
 * Monitor para gestionar un conjunto de lectores y escritores.
 * Varios lectores a la vez, sólo un escritor.
 * Puede producirse una situación de inanición de escritores.
 *
 * @author aalonso
 * @author jpuente
 * @version 24.10.2018
 */
public class RW_Readers implements RW {

    private int nr = 0; // número de lectores
    private int nw = 0; // número de escritores

    @Override
    public synchronized void openReading() {
        try {
            while (nw > 0) wait();
        } catch (InterruptedException ignored) {}
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
        } catch (InterruptedException ignored) {
        }
        nw++;
        assert ( (nw == 0 || nr == 0) && nw <= 1 );
    }

    @Override
    public synchronized void closeWriting() {
        nw--;
        notifyAll();
    }

}

