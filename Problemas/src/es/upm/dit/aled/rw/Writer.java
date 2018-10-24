package es.upm.dit.aled.rw;

import java.util.Random;

/**
 * Writer
 *
 * @author aalonso
 * @author jpuente
 * @version 2018.10.24
 */
public class Writer extends Thread {

    RW rw;
    int id;
    Random random = new Random();

    public Writer(RW rw, int id) {
        this.rw = rw;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                sleep(random.nextInt(6000));        // hace otras cosas
                System.out.println("Escritor " + id + " quiere escribir");
                rw.openWriting();
                System.out.println("Escritor " + id + " empieza a escribir");
                Thread.sleep(random.nextInt(3000)); // escribe
                rw.closeWriting();
                System.out.println("Escritor " + id + " termina de escribir");
            }
        } catch (InterruptedException ie) {
            return;
        }
    }

}
