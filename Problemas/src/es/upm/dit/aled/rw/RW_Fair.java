package es.upm.dit.aled.rw;

/**
 * Monitor para gestionar un conjunto de lectores y escritores.
 * Varios lectores a la vez, sólo un escritor.
 * Los lectores y los escitores accededn por turno.
 * Puede producirse una situación de inanición de lectore.
 *
 * @author aalonso
 * @author jpuente
 * @version 04.11.2014
 */
public class RW_Fair implements RW {

    private int nr = 0;         // número de lectores
    private int nw = 0;         // número de escritores
    private int nr_Waiting = 0; // número de lectore esperando
    private int nw_Waiting = 0; // número de escritores esperando

    private boolean turn_to_write = true;

    private boolean bloqueoEscritor = false;
    private boolean bloqueoLector = false;

    @Override
    public synchronized void openReading() {
        nr_Waiting++;
        while ( nw > 0 || nw_Waiting > 0 && turn_to_write ) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        nr_Waiting--;
        nr++;
        turn_to_write = true;
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
        while ( nr > 0 || nw >0 || nr_Waiting > 0 && !turn_to_write ) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        nw_Waiting--;
        nw++;
        turn_to_write = false;
        assert ( (nw == 0 || nr == 0) && nw <= 1 );
    }

    @Override
    public synchronized void closeWriting() {
        nw--;
        notifyAll();
    }
}