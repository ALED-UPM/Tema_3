package es.upm.dit.aled.rw;

/**
 * Monitor para gestionar un conjunto de lectores y escritores.
 * Varios lectores a la vez, sólo un escritor.
 * Los escritores tienen prioridad
 * Puede producirse una situación de inanición de lectores.
 * 
 * @author aalonso
 * @author jpuente
 * @version 04.11.2014
 */
public class RW_Writers implements RW {

    private int nr = 0;         // número de lectores
    private int nw = 0;         // número de escritores
    private int nw_Waiting = 0; // número de escritores esperando

    @Override
    public synchronized void openReading() {
        try {
            while (nw > 0 || nw_Waiting > 0) wait();
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
        nw_Waiting++;
        try {
            while (nr > 0 || nw > 0) wait();
        } catch (InterruptedException ignored) {
        }
        nw_Waiting--;
        nw++;
        assert ( (nw == 0 || nr == 0) && nw <= 1 );
    }

    @Override
    public synchronized void closeWriting() {
        nw--;
        notifyAll();
    }

}